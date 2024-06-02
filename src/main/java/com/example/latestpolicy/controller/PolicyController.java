package com.example.latestpolicy.controller;

import com.example.latestpolicy.entity.Policy;
import com.example.latestpolicy.server.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/latest-policies")
    public Map<String, Object> getLatestPolicies() {
        List<Policy> policies = policyService.getLatestPolicies();

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

        AtomicInteger counter = new AtomicInteger(1);

        data.put("policy", policies.stream().map(policy -> {
            Map<String, Object> policyData = new HashMap<>();
            policyData.put("id", counter.getAndIncrement());
            policyData.put("policy_id", policy.getId());
            policyData.put("policy_title", policy.getPolicyTitle());
            return policyData;
        }).collect(Collectors.toList()));

        response.put("code", "200");
        response.put("data", data);
        response.put("msg", "请求成功");

        return response;
    }
}