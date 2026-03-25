package com.example.demo.controller;

import com.example.demo.repository.UserSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserSummaryRepository userSummaryRepository;

    // API: /users/by-type?type=Pre-Checker
    @GetMapping("/by-type")
    public List<String> getUsersByType(@RequestParam("type") String type) {
        return userSummaryRepository.findNamesByType(type);
    }
    @GetMapping("/user-details")
    public List<Object[]> getUserDetails(@RequestParam("name") String name) {
        return userSummaryRepository.getUserDetails(name);
    }
    
    @GetMapping("/all-details")
    public List<Object[]> getAllUserDetails() {
        return userSummaryRepository.getAllUserDetails();
    }
}
