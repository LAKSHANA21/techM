package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "userlogins")
public class Userlogin {
    @Id
    @Column(name = "user_id")
    private String userId;  // This should store the value directly
    
    private String email;
    private String phoneNumber;
    private String password;
    private String role;
    private String username;
    
    @OneToOne
    @JoinColumn(name = "linked_user_id", referencedColumnName = "user_id")  // Changed column name
    @JsonManagedReference
    private Users user;
    
    // CORRECTED getter - returns its own value
    public String getUserId() {
        return this.userId;
    }
    
    // ADDED setter
    public void setUserId(String userId) {
        this.userId = userId;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	 @JsonIgnore
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Userlogin(String email, String phoneNumber, String password, String role, String username,
			Users user) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.username = username;
		this.user = user;
	}

	public Userlogin() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}