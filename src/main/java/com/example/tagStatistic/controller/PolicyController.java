package com.example.tagStatistic.controller;

import com.example.tagStatistic.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/policies/top-tags")
    public Map<String, Object> getTopTags() {
        List<Object[]> topTags = policyService.getTopTags();
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "请求成功");
        response.put("code", "200");

        AtomicInteger id = new AtomicInteger(1);
        Map<String, Object> data = new HashMap<>();
        List<Map<String, Object>> policyList = topTags.stream().map(tag -> {
            Map<String, Object> map = new HashMap<>();
            map.put("tag", tag[0]);
            map.put("tag_number", tag[1]);
            map.put("id",id.getAndIncrement());
            return map;
        }).collect(Collectors.toList());

        data.put("policy", policyList);
        response.put("data", data);
        return response;
    }
}
