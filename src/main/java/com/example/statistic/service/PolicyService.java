package com.example.statistic.service;

import com.example.statistic.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public String getPoliciesCountByYear() {
        List<Object[]> results = policyRepository.countPoliciesByYear();
        return results.stream()
                .map(result -> result[0] + ":" + result[1])
                .collect(Collectors.joining("; "));
    }
}
