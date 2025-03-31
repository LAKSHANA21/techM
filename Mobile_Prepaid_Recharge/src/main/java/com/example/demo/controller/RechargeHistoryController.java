package com.example.demo.controller;

import com.example.demo.dto.RechargeHistoryDTO;
import com.example.demo.model.RechargeHistory;
import com.example.demo.service.RechargeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rechargehistory")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class RechargeHistoryController {

    @Autowired
    private RechargeHistoryService rechargeHistoryService;

    @GetMapping
    public ResponseEntity<List<RechargeHistoryDTO>> getAllRechargeHistory() {
        List<RechargeHistoryDTO> rechargeHistory = rechargeHistoryService.getAllRechargeHistory();
        return ResponseEntity.ok(rechargeHistory);
    }

    @GetMapping("/{rechargeId}")
    public ResponseEntity<RechargeHistory> getRechargeHistoryById(@PathVariable String rechargeId) {
        RechargeHistory rechargeHistory = rechargeHistoryService.getRechargeHistoryById(rechargeId); // No need for Optional
        return ResponseEntity.ok(rechargeHistory);
    }

    @PostMapping("/create")
    public ResponseEntity<RechargeHistory> createRechargeHistory(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("userId");
        String planId = requestBody.get("planId");
        String paymentId = requestBody.get("paymentId");

        RechargeHistory rechargeHistory = rechargeHistoryService.createRechargeHistory(userId, planId, paymentId);
        return ResponseEntity.ok(rechargeHistory);
    }



    @PutMapping("/{rechargeId}")
    public ResponseEntity<RechargeHistory> updateRechargeHistory(@PathVariable String rechargeId, @RequestBody RechargeHistory updatedRechargeHistory) {
        RechargeHistory rechargeHistory = rechargeHistoryService.updateRechargeHistory(rechargeId, updatedRechargeHistory);
        return ResponseEntity.ok(rechargeHistory);
    }

    @DeleteMapping("/{rechargeId}")
    public ResponseEntity<String> deleteRechargeHistory(@PathVariable String rechargeId) {
        rechargeHistoryService.deleteRechargeHistory(rechargeId);
        return ResponseEntity.ok("Recharge history deleted successfully");
    }
}