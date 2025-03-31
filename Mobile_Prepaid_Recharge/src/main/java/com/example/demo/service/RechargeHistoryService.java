package com.example.demo.service;

import com.example.demo.dto.RechargeHistoryDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Payments;
import com.example.demo.model.RechargeHistory;
import com.example.demo.model.Rechargeplans;
import com.example.demo.model.Users;
import com.example.demo.model.*;
import com.example.demo.repository.PaymentsRepository;
import com.example.demo.repository.RechargeHistoryRepository;
import com.example.demo.repository.RechargeplansRepository;
import com.example.demo.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RechargeHistoryService {

	 private final RechargeHistoryRepository rechargeHistoryRepository;
	 private final UsersRepository usersRepository;
	 private final RechargeplansRepository rechargeplansRepository;
	 private final PaymentsRepository paymentsRepository;
    
    @Autowired
    public RechargeHistoryService(
        RechargeHistoryRepository rechargeHistoryRepository,
        UsersRepository usersRepository,
        RechargeplansRepository rechargeplansRepository,
        PaymentsRepository paymentsRepository) {
        
        this.rechargeHistoryRepository = rechargeHistoryRepository;
        this.usersRepository = usersRepository;
        this.rechargeplansRepository = rechargeplansRepository;
        this.paymentsRepository = paymentsRepository;
    }
    
    public Users getUserById(String userId) {
        return usersRepository.findById(userId)
               .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<RechargeHistoryDTO> getAllRechargeHistory() {
        return rechargeHistoryRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    private RechargeHistoryDTO convertToDTO(RechargeHistory history) {
        RechargeHistoryDTO dto = new RechargeHistoryDTO();
        dto.setRechargeId(history.getRechargeId());
        dto.setRechargeDate(history.getRechargeDate());
        dto.setUserId(history.getUser() != null ? history.getUser().getUserId() : null);
        dto.setPlanId(history.getPlan() != null ? history.getPlan().getPlanId() : null);
        dto.setPaymentId(history.getPayment() != null ? history.getPayment().getPaymentId() : null);
        return dto;
    }

    public RechargeHistory getRechargeHistoryById(String rechargeId) {
        return rechargeHistoryRepository.findById(rechargeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recharge history not found with ID: " + rechargeId));
    }

    public RechargeHistory createRechargeHistory(String userId, String planId, String paymentId) {
        Users user = usersRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        Rechargeplans plan = rechargeplansRepository.findById(planId)
            .orElseThrow(() -> new ResourceNotFoundException("Plan not found with ID: " + planId));

        Payments payment = paymentsRepository.findById(paymentId)
            .orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + paymentId));

        RechargeHistory rechargeHistory = new RechargeHistory();
        rechargeHistory.setUser(user);
        rechargeHistory.setPlan(plan);
        rechargeHistory.setPayment(payment);
        rechargeHistory.setRechargeDate(LocalDate.now());

        return rechargeHistoryRepository.save(rechargeHistory);
    }


    public RechargeHistory updateRechargeHistory(String rechargeId, RechargeHistory updatedRechargeHistory) {
        return rechargeHistoryRepository.findById(rechargeId)
            .map(existingHistory -> {
                // Fetch and set User entity
                Users user = usersRepository.findById(updatedRechargeHistory.getUser().getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + updatedRechargeHistory.getUser().getUserId()));
                existingHistory.setUser(user);

                // Fetch and set Plan entity
                Rechargeplans plan = rechargeplansRepository.findById(updatedRechargeHistory.getPlan().getPlanId())
                    .orElseThrow(() -> new ResourceNotFoundException("Plan not found with ID: " + updatedRechargeHistory.getPlan().getPlanId()));
                existingHistory.setPlan(plan);

                // Fetch and set Payment entity
                Payments payment = paymentsRepository.findById(updatedRechargeHistory.getPayment().getPaymentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + updatedRechargeHistory.getPayment().getPaymentId()));
                existingHistory.setPayment(payment);

                existingHistory.setRechargeDate(updatedRechargeHistory.getRechargeDate());
                return rechargeHistoryRepository.save(existingHistory);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Recharge history not found with ID: " + rechargeId));
    }
    
    public boolean deleteRechargeHistory(String rechargeId) {
        if (!rechargeHistoryRepository.existsById(rechargeId)) {
            throw new ResourceNotFoundException("Recharge history not found with ID: " + rechargeId);
        }
        rechargeHistoryRepository.deleteById(rechargeId);
        return true;
    }
}