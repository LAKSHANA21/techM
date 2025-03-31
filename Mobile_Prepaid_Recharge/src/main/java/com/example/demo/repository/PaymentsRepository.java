package com.example.demo.repository;

import com.example.demo.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, String> {
    @Query("SELECT p FROM Payments p WHERE p.paymentStatus = :paymentStatus")
    List<Payments> findByPaymentStatus(@Param("paymentStatus") String paymentStatus);

    @Query("SELECT p FROM Payments p WHERE p.rechargeId = :rechargeId")
    List<Payments> findByRechargeId(@Param("rechargeId") String rechargeId); // Custom query to find payments by recharge ID
    
    List<Payments> findByRechargeHistory_RechargeId(String rechargeId);
    
  
}
