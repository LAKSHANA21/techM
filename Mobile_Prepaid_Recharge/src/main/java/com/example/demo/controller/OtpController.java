package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OtpService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        try {
            otpService.sendOtp(email);
            return ResponseEntity.ok("OTP sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error sending OTP: " + e.getMessage());
        }
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestParam String email, @RequestParam String otp) {
        boolean isValid = otpService.validateOtp(email, otp);
        if (isValid) {
            return ResponseEntity.ok().body(Map.of("message", "OTP validated successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid OTP"));
        }
    }
    
    @PostMapping("/send-email")
    public ResponseEntity<?> sendPaymentSuccessEmail(@RequestBody Map<String, Object> request) {
        String email = (String) request.get("email");
        String paymentId = (String) request.get("paymentId"); // Razorpay transaction ID
        Map<String, Object> planDetails = (Map<String, Object>) request.get("plan");

        if (email == null || planDetails == null || paymentId == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email, plan details, and payment ID are required"));
        }

        // Convert plan details to string format
        Map<String, String> formattedPlanDetails = new HashMap<>();
        formattedPlanDetails.put("planName", String.valueOf(planDetails.get("planName")));
        formattedPlanDetails.put("price", String.valueOf(planDetails.get("price")));
        formattedPlanDetails.put("validity", String.valueOf(planDetails.get("validity")));
        formattedPlanDetails.put("description", String.valueOf(planDetails.get("description"))); // Ensure this field is included
        formattedPlanDetails.put("category", String.valueOf(planDetails.get("category"))); // Ensure this field is included

        otpService.sendPaymentSuccessEmail(email, formattedPlanDetails, paymentId);

        return ResponseEntity.ok().body(Map.of("message", "Payment success email sent successfully"));
    }

}