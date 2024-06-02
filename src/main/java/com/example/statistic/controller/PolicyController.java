package com.example.statistic.controller;

import com.example.statistic.response.PolicyCountResponse;
import com.example.statistic.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService policyService;
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/policies/countByYear")
    public PolicyCountResponse getPoliciesCountByYear() {
        String data = policyService.getPoliciesCountByYear();
        if (data != null && !data.isEmpty()) {
            return new PolicyCountResponse(200, "请求成功", data);
        } else {
            return new PolicyCountResponse(201, "请求失败", null);
        }
    }
}
