package com.jessie.feign.service.impl;

import com.jessie.feign.service.Iservice;
import org.springframework.stereotype.Service;

@Service
public class IserviceImpl implements Iservice {
    @Override
    public Object getUser(Long id) {
        return "I have a error, so You must restart me!" + id;
    }
}
