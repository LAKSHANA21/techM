package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Rechargeplans;
import com.example.demo.service.RechargeplansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.security.CorsConfig;

import java.util.List;

@RestController
@RequestMapping("/api/rechargeplans")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class RechargePlansController {

    @Autowired
    private RechargeplansService rechargeplansService;

    @GetMapping("/all")
    public ResponseEntity<List<Rechargeplans>> getAllPlans() {
        return ResponseEntity.ok(rechargeplansService.getAllPlans());
    }

    @GetMapping("/{planId}")
    public ResponseEntity<Rechargeplans> getPlanById(@PathVariable String planId) {
        Rechargeplans plan = rechargeplansService.getPlanById(planId); // No need for Optional
        return ResponseEntity.ok(plan);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Rechargeplans>> getPlansByCategory(@PathVariable String categoryName) {
        List<Rechargeplans> plans = rechargeplansService.getPlansByCategoryName(categoryName);
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/below-price/{price}")
    public ResponseEntity<List<Rechargeplans>> getPlansBelowPrice(@PathVariable double price) {
        List<Rechargeplans> plans = rechargeplansService.getPlansBelowPrice(price);
        return ResponseEntity.ok(plans);
    }

    @PostMapping("/add")
    public ResponseEntity<Rechargeplans> addPlan(@RequestBody Rechargeplans plan) {
        Rechargeplans createdPlan = rechargeplansService.addPlan(plan);
        return ResponseEntity.ok(createdPlan);
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable String planId) {
        try {
            rechargeplansService.deletePlan(planId);
            return ResponseEntity.ok("Recharge plan with ID " + planId + " deleted successfully.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting plan: " + e.getMessage());
        }
    }
    
    @PutMapping("/update")
    public ResponseEntity<Rechargeplans> updatePlan(@RequestBody Rechargeplans plan) {
        Rechargeplans updatedPlan = rechargeplansService.updatePlan(plan);
        return ResponseEntity.ok(updatedPlan);
    }
}