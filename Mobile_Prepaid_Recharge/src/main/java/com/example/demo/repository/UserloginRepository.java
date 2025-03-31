package com.example.demo.repository;

import com.example.demo.model.Userlogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserloginRepository extends JpaRepository<Userlogin, String> {

    // HQL query to fetch users by role
	@Query("FROM Userlogin u WHERE u.role = :role")
    List<Userlogin> findUsersByRole(@Param("role") String role);

    // HQL query to find user by username
    @Query("FROM Userlogin u WHERE u.username = :username")
    Optional<Userlogin> findUserByUsername(@Param("username") String username);

    // HQL query to find user by email and phone number
    @Query("FROM Userlogin u WHERE u.email = :email")
    Optional<Userlogin> findUserByEmail(@Param("email") String email);

    // HQL query to fetch all users
    @Query("FROM Userlogin u")
    List<Userlogin> findAllUsers();
    
    Optional<Userlogin> findByEmail(String email);
    
    Optional<Userlogin> findById(String userId);
    
    @Query("FROM Userlogin u WHERE u.email = :email AND u.phoneNumber = :phoneNumber")
    Optional<Userlogin> findUserByEmailAndPhoneNumber(
        @Param("email") String email, 
        @Param("phoneNumber") String phoneNumber
    );
}