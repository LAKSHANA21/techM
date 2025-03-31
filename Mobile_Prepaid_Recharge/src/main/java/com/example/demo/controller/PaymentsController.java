package com.example.demo.controller;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.model.Payments;
import com.example.demo.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<PaymentDTO> payments = paymentsService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable String paymentId) {
        Payments payment = paymentsService.getPaymentById(paymentId); // No need for Optional
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping("/recharge/{rechargeId}")
    public ResponseEntity<List<Payments>> getPaymentsByRechargeId(@PathVariable String rechargeId) {
        List<Payments> payments = paymentsService.getPaymentsByRechargeId(rechargeId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Payments> createPayment(@RequestBody Payments payment) {
        Payments createdPayment = paymentsService.createPayment(payment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payments> updatePayment(@PathVariable String paymentId, @RequestBody Payments updatedPayment) {
        Payments payment = paymentsService.updatePayment(paymentId, updatedPayment);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable String paymentId) {
        paymentsService.deletePayment(paymentId);
        return new ResponseEntity<>("Payment deleted successfully", HttpStatus.OK);
    }
}