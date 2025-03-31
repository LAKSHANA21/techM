package com.example.demo.service;

import com.example.demo.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private JavaMailSender mailSender;

    private final Map<String, String> otpStore = new HashMap<>();

    public void sendOtp(String email) {
        if (email == null || email.isEmpty()) {
            throw new ValidationException("Email cannot be null or empty");
        }

        try {
            String otp = generateOtp();
            otpStore.put(email, otp);
            System.out.println("OTP stored for email: " + email + ", OTP: " + otp);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Your OTP for MOBI-COMM Login");
            message.setText("Your OTP is: " + otp);

            mailSender.send(message);
            System.out.println("OTP sent successfully to " + email);
        } catch (Exception e) {
            System.err.println("Error sending OTP: " + e.getMessage());
            throw new RuntimeException("Error sending OTP", e);
        }
    }
    

    private String generateOtp() {
        Random random = new Random();
        return String.valueOf(100000 + random.nextInt(900000)); // 6-digit OTP
    }

    public boolean validateOtp(String email, String otp) {
        if (email == null || email.isEmpty() || otp == null || otp.isEmpty()) {
            throw new ValidationException("Email and OTP cannot be null or empty");
        }

        String storedOtp = otpStore.get(email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            otpStore.remove(email); // Clear the OTP after validation
            return true;
        }
        return false;
    }
    
    public void sendPaymentSuccessEmail(String toEmail, Map<String, String> planDetails, String transactionId) {
        if (toEmail == null || toEmail.isEmpty() || planDetails == null || transactionId == null || transactionId.isEmpty()) {
            throw new ValidationException("Email, plan details, and transaction ID cannot be null or empty");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Payment Successful - Mobi-Comm");

        String emailText = String.format(
            "Dear Customer,\n\n" +
            "Your payment was successful. Below are the details of your recharge:\n\n" +
            "Transaction ID: %s\n" +
            "Plan Name: %s\n" +
            "Plan Price: %s\n" +
            "Plan Validity: %s\n" +
            "Plan Description: %s\n\n" +
            "Thank you for choosing Mobi-Comm!\n",
            transactionId, // Razorpay transaction ID
            planDetails.get("planName"), // Plan name
            planDetails.get("price"), // Plan price
            planDetails.get("validity"), // Plan validity
            planDetails.get("description") // Plan description
        );
        message.setText(emailText);
        mailSender.send(message);
    }
}