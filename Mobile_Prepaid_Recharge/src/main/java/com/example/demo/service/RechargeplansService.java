package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Rechargeplans;
import com.example.demo.repository.RechargeplansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RechargeplansService {

    @Autowired
    private RechargeplansRepository rechargeplansRepository;

    public List<Rechargeplans> getAllPlans() {
        return rechargeplansRepository.findAll();
    }

    public Rechargeplans getPlanById(String planId) {
        return rechargeplansRepository.findById(planId)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found with ID: " + planId));
    }

    public List<Rechargeplans> getPlansByCategoryName(String categoryName) {
        List<Rechargeplans> plans = rechargeplansRepository.findByCategoryName(categoryName);
        if (plans.isEmpty()) {
            throw new ResourceNotFoundException("No plans found for category: " + categoryName);
        }
        return plans;
    }

    public List<Rechargeplans> getPlansBelowPrice(double price) {
        List<Rechargeplans> plans = rechargeplansRepository.findByPriceLessThan(price);
        if (plans.isEmpty()) {
            throw new ResourceNotFoundException("No plans found below price: " + price);
        }
        return plans;
    }

    public Rechargeplans addPlan(Rechargeplans plan) {
        if (plan.getPlanId() == null || plan.getPlanId().isEmpty()) {
            throw new ValidationException("Plan ID cannot be null or empty");
        }
        return rechargeplansRepository.save(plan);
    }
    
    public void deletePlan(String planId) {
        // Check if plan exists first
        if (!rechargeplansRepository.existsById(planId)) {
            throw new ResourceNotFoundException("Plan not found with ID: " + planId);
        }
        
        try {
            rechargeplansRepository.deleteById(planId);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Cannot delete plan because it's being referenced by other records");
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Plan not found with ID: " + planId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete plan: " + e.getMessage());
        }
    }
    
    public Rechargeplans updatePlan(Rechargeplans plan) {
        if (!rechargeplansRepository.existsById(plan.getPlanId())) {
            throw new ResourceNotFoundException("Plan not found with ID: " + plan.getPlanId());
        }
        return rechargeplansRepository.save(plan);
    }
}