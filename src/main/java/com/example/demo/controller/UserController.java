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

   
    @GetMapping("/by-type")
    public List<String> getUsersByType(@RequestParam("type") String type) {
        return userSummaryRepository.findNamesByType(type);
    }
    @GetMapping("/user-details")
    @ResponseBody
    public List<Object[]> getUserDetails(
            @RequestParam("name") String name,
            @RequestParam("type") String type) {

        return userSummaryRepository.getUserDetails(name, type);
    }
    
    @GetMapping("/all-users")
    @ResponseBody
    public List<Object[]> getAllUsersByType(
            @RequestParam("type") String type) {

        return userSummaryRepository.getAllUserDetailsByType(type);
    }
}
