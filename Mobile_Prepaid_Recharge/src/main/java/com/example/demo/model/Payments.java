package com.example.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    private String paymentId;

    private String paymentMethod;
    private Double amount;
    private String paymentStatus;
    @Column(name = "recharge_id", insertable = false, updatable = false)
    private String rechargeId;
    @Column(name = "payment_date")
    private LocalDate paymentDate;   // Add this field

    @OneToOne(mappedBy = "payment")
    @JsonIgnoreProperties("payment")  // Prevents circular reference
    private RechargeHistory rechargeHistory;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("payments")  // Prevents circular reference
    private Users user;

	public String getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(String rechargeId) {
		this.rechargeId = rechargeId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public RechargeHistory getRechargeHistory() {
		return rechargeHistory;
	}

	public void setRechargeHistory(RechargeHistory rechargeHistory) {
		this.rechargeHistory = rechargeHistory;
	}

	public Payments(String paymentId, String paymentMethod, Double amount, String paymentStatus,
			RechargeHistory rechargeHistory) {
		super();
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.rechargeHistory = rechargeHistory;
	}

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}