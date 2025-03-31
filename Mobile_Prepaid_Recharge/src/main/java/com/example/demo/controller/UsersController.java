package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserExpiryDTO;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return usersService.getAllUsersWithDetails();
    }

    @GetMapping("/{userId}")
    public Optional<Users> getUserById(@PathVariable String userId) {
        return usersService.getUserById(userId);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        try {
            Users registeredUser = usersService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(
                Map.of("error", e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                Map.of("error", "Registration failed: " + e.getMessage())
            );
        }
    }
    
    @PutMapping("/{userId}")
    public Users updateUser(@PathVariable String userId, @RequestBody Users updatedUser) {
        return usersService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return usersService.deleteUser(userId) ? "User deleted successfully" : "User not found";
    }
    
    @GetMapping("/expiring-soon")
    public ResponseEntity<List<UserExpiryDTO>> getUsersWithExpiryWithinDays(
        @RequestParam(defaultValue = "3") int days) {
        return ResponseEntity.ok(usersService.getUsersWithExpiryWithinDays(days));
    }
}