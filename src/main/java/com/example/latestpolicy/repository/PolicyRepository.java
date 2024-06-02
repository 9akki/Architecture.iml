package com.example.latestpolicy.repository;

import com.example.latestpolicy.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findTop5ByOrderByPubDateDesc();
}