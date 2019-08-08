package com.jessie.consumermovie.controller;

import com.jessie.consumermovie.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  DiscoveryClient discoveryClient;
    @GetMapping("/user/{id}")
    public User findById(@PathVariable String id){

        return restTemplate.getForObject("http://provider-user/getUser?id=" +id,User.class);
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return  this.discoveryClient.getInstances("provider-user");
    }

}
