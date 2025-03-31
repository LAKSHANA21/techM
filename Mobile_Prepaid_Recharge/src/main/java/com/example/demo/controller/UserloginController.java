package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Userlogin;
import com.example.demo.service.OtpService;
import com.example.demo.service.UserloginService;
import com.example.demo.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.demo.security.CorsConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/userlogin")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class UserloginController {

    private final UserloginService userloginService;
    
    @Autowired
    private AuthenticationManager authenticationManager; 
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private OtpService otpService;

    public UserloginController(UserloginService userloginService) {
        this.userloginService = userloginService;
    }

    // Endpoint to fetch users by role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<Userlogin>> getUsersByRole(@PathVariable String role) {
        List<Userlogin> users = userloginService.getUsersByRole(role);
        return ResponseEntity.ok(users);
    }

    // Endpoint to fetch a user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<Userlogin> getUserByUsername(@PathVariable String username) {
        Userlogin user = userloginService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Userlogin user) {
        // Ensure user_id is set
        if (user.getUserId() == null || user.getUserId().isEmpty()) {
            return ResponseEntity.badRequest().body("User ID is required");
        }

        userloginService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

//     Endpoint to validate user credentials
    @PostMapping("/validate")
    public ResponseEntity<?> validateUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email").trim(); // Trim whitespace
        String phoneNumber = credentials.get("phoneNumber").trim(); // Trim whitespace

        System.out.println("Received email: " + email); // Log the email
        System.out.println("Received phone number: " + phoneNumber); // Log the phone number

        // Validate the credentials
        Map<String, Object> validationResult = userloginService.validateUser(email, phoneNumber);

        if ((boolean) validationResult.get("valid")) {
            return ResponseEntity.ok().body(validationResult);
        } else {
            return ResponseEntity.status(401).body("Invalid email or phone number");
        }
    }

    // Endpoint to fetch all users
    @GetMapping("/all")
    public ResponseEntity<List<Userlogin>> getAllUsers() {
        List<Userlogin> users = userloginService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/details/{userId}")
    public ResponseEntity<Userlogin> getCustomerDetails(@PathVariable String userId) {
        Userlogin user = userloginService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/auth/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7); // Remove "Bearer " prefix
            }

            if (jwtUtil.isTokenValid(token)) {
                return ResponseEntity.ok().build(); // Token is valid
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Token is invalid
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Server error
        }
    }
    
    @PostMapping("/admin-login")
    public ResponseEntity<?> adminLogin(@RequestBody Userlogin loginRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            UserDetails userDetails = userloginService.loadUserByUsername(loginRequest.getEmail());
            Userlogin user = userloginService.findByEmail(loginRequest.getEmail());

            if (user != null && "ADMIN".equals(user.getRole())) {
                String accessToken = jwtUtil.generateAccessToken(user.getEmail());
                String refreshToken = jwtUtil.generateRefreshToken(user.getEmail());

                Map<String, String> response = new HashMap<>();
                response.put("accessToken", accessToken);
                response.put("refreshToken", refreshToken);
                response.put("message", "Admin login successful");
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(403).body("Access Denied: Not an Admin");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String refreshToken) {
        try {
            if (refreshToken != null && refreshToken.startsWith("Bearer ")) {
                refreshToken = refreshToken.substring(7); // Remove "Bearer " prefix
            }

            if (jwtUtil.isTokenValid(refreshToken)) {
                String email = jwtUtil.extractEmail(refreshToken);
                String newAccessToken = jwtUtil.generateAccessToken(email);

                Map<String, String> response = new HashMap<>();
                response.put("accessToken", newAccessToken);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(401).body("Invalid or expired refresh token");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error");
        }
    }
    
    @PostMapping("/validate-credentials")
    public ResponseEntity<?> validateCredentials(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String phoneNumber = credentials.get("phoneNumber");

        try {
            Map<String, Object> validationResult = userloginService.validateUser(email, phoneNumber);
            if ((boolean) validationResult.get("valid")) {
                // Send OTP to the user's email
                otpService.sendOtp(email);

                // Return a response indicating OTP has been sent
                Map<String, Object> response = new HashMap<>();
                response.put("message", "OTP sent successfully");
                response.put("email", email);
                return ResponseEntity.ok(response);
            }
        } catch (ResourceNotFoundException ex) {
            throw ex; // This will be caught by the GlobalExceptionHandler
        } catch (ValidationException ex) {
            throw ex; // This will be caught by the GlobalExceptionHandler
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
    }

    @PostMapping("/validate-otp")
    @CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
    public ResponseEntity<?> validateOtp(@RequestParam String email, @RequestParam String otp) {
        System.out.println("Received OTP validation request for email: " + email + ", OTP: " + otp);

        boolean isOtpValid = userloginService.validateOtp(email, otp);
        if (isOtpValid) {
            // Generate JWT tokens
            String accessToken = jwtUtil.generateAccessToken(email);
            String refreshToken = jwtUtil.generateRefreshToken(email);

            // Return the tokens
            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", accessToken);
            response.put("refreshToken", refreshToken);
            response.put("message", "OTP validated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid OTP"));
        }
    }
    
}