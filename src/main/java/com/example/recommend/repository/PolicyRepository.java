package com.example.recommend.repository;

import com.example.recommend.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByTagIn(List<String> tags);
}