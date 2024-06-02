package com.example.latestpolicy.server;

import com.example.latestpolicy.entity.Policy;
import com.example.latestpolicy.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> getLatestPolicies() {
        return policyRepository.findTop5ByOrderByPubDateDesc();
    }
}