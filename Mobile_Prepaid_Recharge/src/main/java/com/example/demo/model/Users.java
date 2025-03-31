package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@JsonIgnoreProperties("rechargeHistories")
public class Users {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    // Add this field to match the mappedBy reference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private Userlogin userLogin;

    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String mobileNumber;

    @Temporal(TemporalType.DATE)
    private Date rechargeDate;
    
    @Column(nullable = false)  // This is what's causing the error
    private String password;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<RechargeHistory> rechargeHistories;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    @JsonIgnoreProperties("users")
    private Rechargeplans currentPlan;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Payments> payments;

    // Default constructor
    public Users() {}

    public Users(String userId, String email, String mobileNumber, Date expiryDate, 
                Date rechargeDate, String password, Rechargeplans currentPlan) {
        this.userId = userId;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.expiryDate = expiryDate;
        this.rechargeDate = rechargeDate;
        this.password = password;
        this.currentPlan = currentPlan;
    }
    
    public Rechargeplans getCurrentPlan() {
        return currentPlan;
    }

    public void setCurrentPlan(Rechargeplans currentPlan) {
        this.currentPlan = currentPlan;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

	public String getUserId() {
		return userId;
	}
	
	@JsonIgnore
	public Userlogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(Userlogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RechargeHistory> getRechargeHistories() {
		return rechargeHistories;
	}

	public void setRechargeHistories(List<RechargeHistory> rechargeHistories) {
		this.rechargeHistories = rechargeHistories;
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getRechargeDate() {
		return rechargeDate;
	}

	public void setRechargeDate(Date rechargeDate) {
		this.rechargeDate = rechargeDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    	
}