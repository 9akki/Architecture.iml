package com.example.recommend.server;

import com.example.recommend.entity.Policy;
import com.example.recommend.entity.User;
import com.example.recommend.repository.PolicyRepository;
import com.example.recommend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class recommendServer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> getRecommendedPolicies(String userName) {
        User user = userRepository.findByUserName(userName).orElse(null);
        if (user == null) {
            return Collections.emptyList();
        }

        List<String> keywords = Arrays.asList(user.getUserSub().split(","));
        List<Policy> matchedPolicies = policyRepository.findByTagIn(keywords);

        Collections.shuffle(matchedPolicies);
        return matchedPolicies.stream().limit(5).collect(Collectors.toList());
    }
}
