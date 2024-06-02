package com.example.tagStatistic.service;

import com.example.tagStatistic.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Object[]> getTopTags() {
        List<Object[]> tags = policyRepository.findTopTags();
        return tags.stream().limit(5).collect(Collectors.toList());
    }
}