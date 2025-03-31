package com.example.demo.dto;

import java.sql.Date;

public class UserExpiryDTO {
    private String userId;
    private String mobileNumber;
    private String planId;
    private String rechargeId;
    private java.util.Date expiryDate;  
    private java.util.Date rechargeDate;
    private String paymentId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(String rechargeId) {
		this.rechargeId = rechargeId;
	}
	public java.util.Date getExpiryDate() {
        return expiryDate;
    }
	public void setExpiryDate(java.util.Date expiryDate) {
        this.expiryDate = expiryDate;
    }
	public java.util.Date getRechargeDate() {
        return rechargeDate;
    }
	public void setRechargeDate(java.util.Date rechargeDate) {
        this.rechargeDate = rechargeDate;
    }
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public UserExpiryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserExpiryDTO(String userId, String mobileNumber, String planId, String rechargeId, Date expiryDate,
			Date rechargeDate, String paymentId) {
		super();
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.planId = planId;
		this.rechargeId = rechargeId;
		this.expiryDate = expiryDate;
		this.rechargeDate = rechargeDate;
		this.paymentId = paymentId;
	}
    
    
}
