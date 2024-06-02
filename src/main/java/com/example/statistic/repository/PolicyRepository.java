package com.example.statistic.repository;

import com.example.statistic.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Query("SELECT YEAR(p.pubdate) AS year, COUNT(p) AS count FROM Policy p GROUP BY YEAR(p.pubdate)")
    List<Object[]> countPoliciesByYear();
}
