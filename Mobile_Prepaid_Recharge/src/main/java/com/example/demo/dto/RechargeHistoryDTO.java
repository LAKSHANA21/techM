package com.example.demo.dto;

import java.time.LocalDate;

public class RechargeHistoryDTO {
    private String rechargeId;
    private LocalDate rechargeDate;
    private String userId;
    private String planId;
    private String paymentId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public RechargeHistoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RechargeHistoryDTO(String rechargeId, LocalDate rechargeDate, String userId, String planId,
			String paymentId) {
		super();
		this.rechargeId = rechargeId;
		this.rechargeDate = rechargeDate;
		this.userId = userId;
		this.planId = planId;
		this.paymentId = paymentId;
	}

    
}
