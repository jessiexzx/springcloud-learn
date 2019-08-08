package com.jessie.feign;

import com.jessie.feign.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableHystrixDashboard
public class FeignApplication {

    @Autowired
    private Iservice iservice;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @GetMapping("/feign/user/{id}")
    public Object info(@PathVariable Long id){
        return iservice.getUser(id);
    }

    @GetMapping("/log-user-instance")
public String logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");
        return serviceInstance.getServiceId()+"-"+serviceInstance.getHost()+":"+serviceInstance.getPort();
    }
}
