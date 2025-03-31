package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rechargehistory")
public class RechargeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rechargeId;

    @Column(nullable = false)
    private LocalDate rechargeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("rechargeHistories")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    @JsonIgnoreProperties("rechargeHistories") // Add this to avoid infinite loop
    private Rechargeplans plan;

    @OneToOne(fetch = FetchType.LAZY)  // Changed to LAZY (EAGER can cause performance issues)
    @JoinColumn(name = "payment_id", nullable = false)
    @JsonIgnoreProperties("rechargeHistory")  // Prevents circular reference
    private Payments payment;

    // Constructors
    public RechargeHistory() {}

    public RechargeHistory(String rechargeId, LocalDate rechargeDate, Users user, Rechargeplans plan, Payments payment) {
        this.rechargeId = rechargeId;
        this.rechargeDate = rechargeDate;
        this.user = user;
        this.plan = plan;
        this.payment = payment;
    }

    // Getters and Setters
    public String getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(String rechargeId) {
        this.rechargeId = rechargeId;
    }

    public LocalDate getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(LocalDate rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Rechargeplans getPlan() {
        return plan;
    }

    public void setPlan(Rechargeplans plan) {
        this.plan = plan;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }
}
