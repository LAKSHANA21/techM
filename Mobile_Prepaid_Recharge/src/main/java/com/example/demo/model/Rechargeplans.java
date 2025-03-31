package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "plans")
public class Rechargeplans {
    @Id
    private String planId;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "plan_description")
    private String planDescription;

    @Column(name = "price")
    private double price;

    @Column(name = "validity_days")
    private int validityDays;

    @Column(name = "category_name") // Updated to category_name
    private String categoryName;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RechargeHistory> rechargeHistories;
    
    @OneToMany(mappedBy = "currentPlan")
    @JsonIgnoreProperties("currentPlan")
    private List<Users> users;

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getValidityDays() {
		return validityDays;
	}

	public void setValidityDays(int validityDays) {
		this.validityDays = validityDays;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<RechargeHistory> getRechargeHistories() {
		return rechargeHistories;
	}

	public void setRechargeHistories(List<RechargeHistory> rechargeHistories) {
		this.rechargeHistories = rechargeHistories;
	}

	public Rechargeplans() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rechargeplans(String planId, String planName, String planDescription, double price, int validityDays,
			String categoryName, List<RechargeHistory> rechargeHistories) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planDescription = planDescription;
		this.price = price;
		this.validityDays = validityDays;
		this.categoryName = categoryName;
		this.rechargeHistories = rechargeHistories;
	}
    
    
}