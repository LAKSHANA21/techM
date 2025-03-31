package com.example.demo.repository;

import com.example.demo.model.Users;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	@Query("SELECT u FROM Users u WHERE u.expiryDate BETWEEN :startDate AND :endDate")
	List<Users> findByExpiryDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
	boolean existsByEmail(String email);
    boolean existsByMobileNumber(String mobileNumber);
}