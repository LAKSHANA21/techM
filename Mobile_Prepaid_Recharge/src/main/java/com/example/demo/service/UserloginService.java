package com.example.demo.service;

import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UnauthorizedAccessException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Userlogin;
import com.example.demo.repository.UserloginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UserloginService implements UserDetailsService {

    private final UserloginRepository userloginRepository;
    private final PasswordEncoder passwordEncoder;
    private final OtpService otpService;

    public UserloginService(UserloginRepository userloginRepository, PasswordEncoder passwordEncoder, OtpService otpService) {
        this.userloginRepository = userloginRepository;
        this.passwordEncoder = passwordEncoder;
        this.otpService = otpService;
    }

    // Method to fetch users by role
    public List<Userlogin> getUsersByRole(String role) {
        return userloginRepository.findUsersByRole(role);
    }

    // Method to fetch a user by username
    public Userlogin getUserByUsername(String username) {
        return userloginRepository.findUserByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
    }

    // Method to register a new user with an encrypted password
    public void registerUser(Userlogin user) {
        if (userloginRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new DuplicateResourceException("User with email already exists: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userloginRepository.save(user);
    }

    // Method to validate user credentials
    public Map<String, Object> validateUser(String email, String phoneNumber) {
        Optional<Userlogin> user = userloginRepository.findUserByEmailAndPhoneNumber(email.trim(), phoneNumber.trim());

        if (user.isPresent()) {
            return Map.of("valid", true, "role", user.get().getRole(), "userId", user.get().getUserId());
        } else {
            throw new ResourceNotFoundException("User not found with email: " + email + " and phone number: " + phoneNumber);
        }
    }

    // Method to fetch all users
    public List<Userlogin> getAllUsers() {
        return userloginRepository.findAllUsers();
    }

    // Method to fetch a user by email
    public Userlogin getUserByEmail(String email) {
        return userloginRepository.findUserByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    // Method to fetch a user by ID
    public Userlogin getUserById(String userId) {
        return userloginRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));
    }

    // Method to validate admin credentials
    public Map<String, Object> validateAdmin(String email, String password) {
        Optional<Userlogin> user = userloginRepository.findUserByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            if ("ADMIN".equals(user.get().getRole())) {
                return Map.of("valid", true, "role", user.get().getRole(), "userId", user.get().getUserId());
            } else {
                throw new UnauthorizedAccessException("User is not an admin");
            }
        }
        throw new ValidationException("Invalid email or password");
    }

    // Method to find a user by email
    public Userlogin findByEmail(String email) {
        return userloginRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
    }

    // Method to load user details by username (email)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Userlogin user = userloginRepository.findUserByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    // Method to validate OTP
    public boolean validateOtp(String email, String otp) {
        boolean isValid = otpService.validateOtp(email, otp);
        if (!isValid) {
            throw new ValidationException("Invalid OTP");
        }
        return isValid;
    }
}