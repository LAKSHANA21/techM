package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserExpiryDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.RechargeHistory;
import com.example.demo.model.Userlogin;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

	@Autowired
    private UsersRepository usersRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

//    public List<Users> getAllUsers() {
//        return usersRepository.findAll();
//    }
	
	public List<UserDTO> getAllUsersWithDetails() {
	    List<Users> users = usersRepository.findAll();
	    return users.stream().map(user -> {
	        UserDTO dto = new UserDTO();
	        
	        // Basic fields
	        dto.setUserId(user.getUserId());
	        dto.setEmail(user.getEmail());
	        dto.setMobileNumber(user.getMobileNumber());
	        dto.setExpiryDate(user.getExpiryDate());
	        dto.setRechargeDate(user.getRechargeDate());
	        
	        // Plan details
	        if (user.getCurrentPlan() != null) {
	            dto.setPlanName(user.getCurrentPlan().getPlanName());
	        }
	        
	        // Get the most recent recharge
	        if (user.getRechargeHistories() != null && !user.getRechargeHistories().isEmpty()) {
	            // Sort by recharge date descending
	            List<RechargeHistory> sortedRecharges = user.getRechargeHistories().stream()
	                .sorted(Comparator.comparing(RechargeHistory::getRechargeDate).reversed())
	                .toList();
	            
	            RechargeHistory latestRecharge = sortedRecharges.get(0);
	            dto.setLastRechargeId(latestRecharge.getRechargeId());
	            
	            // Get payment from recharge
	            if (latestRecharge.getPayment() != null) {
	                dto.setLastPaymentId(latestRecharge.getPayment().getPaymentId());
	            }
	        }
	        
	        return dto;
	    }).collect(Collectors.toList());
	}
	
    public Optional<Users> getUserById(String userId) {
        Optional<Users> user = usersRepository.findById(userId);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
        return user;
    }

    public Users createUser(Users user) {
        // Validate required fields
        if (user.getUserId() == null || user.getUserId().isEmpty()) {
            throw new ValidationException("User ID is required");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new ValidationException("Password is required");
        }

        // Check for existing user
        if (usersRepository.existsById(user.getUserId())) {
            throw new ValidationException("User ID already exists");
        }
        if (usersRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already in use");
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Create and link Userlogin
        Userlogin userlogin = new Userlogin();
        userlogin.setUserId(user.getUserId());  // 🔴 Add this line to set userId
        userlogin.setUser(user);
        userlogin.setEmail(user.getEmail());
        userlogin.setPassword(user.getPassword()); // Already encoded

        // Set the relationship
        user.setUserLogin(userlogin);

        // Save both entities
        return usersRepository.save(user); // Cascade will save Userlogin
    }

    public Users updateUser(String userId, Users updatedUser) {
        if (!usersRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
        updatedUser.setUserId(userId);
        return usersRepository.save(updatedUser);
    }

    public boolean deleteUser(String userId) {
        if (!usersRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
        usersRepository.deleteById(userId);
        return true;
    }
    
    public List<UserExpiryDTO> getUsersWithExpiryWithinDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate expiryThreshold = today.plusDays(days);
        
        return usersRepository.findByExpiryDateBetween(today, expiryThreshold)
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    private UserExpiryDTO convertToDTO(Users user) {
        UserExpiryDTO dto = new UserExpiryDTO();
        dto.setUserId(user.getUserId());
        dto.setMobileNumber(user.getMobileNumber());
        dto.setExpiryDate(user.getExpiryDate());
        dto.setRechargeDate(user.getRechargeDate());
        
        if(user.getCurrentPlan() != null) {
            dto.setPlanId(user.getCurrentPlan().getPlanId());
        }
        
        if(user.getRechargeHistories() != null && !user.getRechargeHistories().isEmpty()) {
            RechargeHistory latestRecharge = user.getRechargeHistories().get(0);
            dto.setRechargeId(latestRecharge.getRechargeId());
            
            if(latestRecharge.getPayment() != null) {
                dto.setPaymentId(latestRecharge.getPayment().getPaymentId());
            }
        }
        
        return dto;
    }
}