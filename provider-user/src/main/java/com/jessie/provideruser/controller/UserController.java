package com.jessie.provideruser.controller;

import com.jessie.provideruser.bean.User;
import com.jessie.provideruser.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser")
    public Object getUser(@RequestParam Long id){
        Optional<User> user =userRepository.findById(id);
        return user;
    }



}
