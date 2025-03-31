package com.example.demo.service;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Payments;
import com.example.demo.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

    public List<PaymentDTO> getAllPayments() {
        return paymentsRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }
    
    private PaymentDTO convertToDTO(Payments payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setPaymentId(payment.getPaymentId());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setAmount(payment.getAmount());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setRechargeId(payment.getRechargeHistory() != null ? 
                         payment.getRechargeHistory().getRechargeId() : null);
        return dto;
    }

    public Payments getPaymentById(String paymentId) {
        return paymentsRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + paymentId));
    }

    public Payments createPayment(Payments payment) {
        if (payment.getPaymentId() == null || payment.getPaymentId().isEmpty()) {
            throw new ValidationException("Payment ID cannot be null or empty");
        }
        return paymentsRepository.save(payment);
    }

    public Payments updatePayment(String paymentId, Payments updatedPayment) {
        if (!paymentsRepository.existsById(paymentId)) {
            throw new ResourceNotFoundException("Payment not found with ID: " + paymentId);
        }
        updatedPayment.setPaymentId(paymentId); // Ensure the ID is set correctly
        return paymentsRepository.save(updatedPayment);
    }

    public boolean deletePayment(String paymentId) {
        if (!paymentsRepository.existsById(paymentId)) {
            throw new ResourceNotFoundException("Payment not found with ID: " + paymentId);
        }
        paymentsRepository.deleteById(paymentId);
        return true;
    }

    public List<Payments> getPaymentsByRechargeId(String rechargeId) {
        List<Payments> payments = paymentsRepository.findByRechargeId(rechargeId);
        if (payments.isEmpty()) {
            throw new ResourceNotFoundException("No payments found for recharge ID: " + rechargeId);
        }
        return payments;
    }
}