package com.jessie.feign.service;

import com.jessie.feign.service.impl.IserviceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "provider-user",fallback = IserviceImpl.class)
public interface Iservice {

    @RequestMapping("/getUser")
    Object getUser(@RequestParam(value = "id") Long id);
}
