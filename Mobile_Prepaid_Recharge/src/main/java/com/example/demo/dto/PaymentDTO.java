package com.example.demo.dto;

import java.time.LocalDate;

public class PaymentDTO {
    private String paymentId;
    private String paymentMethod;
    private Double amount;
    private String paymentStatus;
    private String rechargeId;
    private LocalDate paymentDate;
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
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDTO(String paymentId, String paymentMethod, Double amount, String paymentStatus, String rechargeId,
			LocalDate paymentDate) {
		super();
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.rechargeId = rechargeId;
		this.paymentDate = paymentDate;
	}

    
}