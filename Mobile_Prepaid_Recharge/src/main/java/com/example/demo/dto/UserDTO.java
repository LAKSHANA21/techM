package com.example.demo.dto;

import java.util.Date;

public class UserDTO {
    private String userId;
    private String email;
    private String mobileNumber;
    private Date expiryDate;
    private Date rechargeDate;
    private String planName;       // From RechargePlan
    private String lastRechargeId; // From RechargeHistory
    private String lastPaymentId;  // From Payment

    // Constructors
    public UserDTO() {}

    public UserDTO(String userId, String email, String mobileNumber, Date expiryDate, Date rechargeDate, String planName, String lastRechargeId, String lastPaymentId) {
        this.userId = userId;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.expiryDate = expiryDate;
        this.rechargeDate = rechargeDate;
        this.planName = planName;
        this.lastRechargeId = lastRechargeId;
        this.lastPaymentId = lastPaymentId;
    }

    // Getters & Setters (Generate using your IDE)
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    
    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
    
    public Date getRechargeDate() { return rechargeDate; }
    public void setRechargeDate(Date rechargeDate) { this.rechargeDate = rechargeDate; }
    
    public String getPlanName() { return planName; }
    public void setPlanName(String planName) { this.planName = planName; }
    
    public String getLastRechargeId() { return lastRechargeId; }
    public void setLastRechargeId(String lastRechargeId) { this.lastRechargeId = lastRechargeId; }
    
    public String getLastPaymentId() { return lastPaymentId; }
    public void setLastPaymentId(String lastPaymentId) { this.lastPaymentId = lastPaymentId; }
}