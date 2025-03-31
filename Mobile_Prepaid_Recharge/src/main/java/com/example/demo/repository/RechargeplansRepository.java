package com.example.demo.repository;

import com.example.demo.model.Rechargeplans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeplansRepository extends JpaRepository<Rechargeplans, String> {

    @Query("SELECT r FROM Rechargeplans r WHERE r.categoryName = :categoryName")
    List<Rechargeplans> findByCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT r FROM Rechargeplans r WHERE r.price < :price")
    List<Rechargeplans> findByPriceLessThan(@Param("price") double price);
}
