package com.example.recommend.controller;

import com.example.recommend.server.recommendServer;
import com.example.recommend.entity.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class recommendController {

    @Autowired
    private recommendServer recommendServer;

    @GetMapping("/recommendations/{userName}")
    public Map<String, Object> getRecommendations(@PathVariable String userName) {
        List<Policy> policies = recommendServer.getRecommendedPolicies(userName);

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

        AtomicInteger counter = new AtomicInteger(1);

        data.put("policy", policies.stream().map(policy -> {
            Map<String, Object> policyData = new HashMap<>();
            policyData.put("id", counter.getAndIncrement());
            policyData.put("policy_id", policy.getId());
            policyData.put("policy_title", policy.getPolicyTitle());
            policyData.put("policy_date", policy.getPolicyDate());
            return policyData;
        }).collect(Collectors.toList()));

        response.put("code", "200");
        response.put("data", data);
        response.put("msg", "请求成功");

        return response;
    }
}
