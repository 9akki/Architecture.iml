package com.example.tagStatistic.repository;

import com.example.tagStatistic.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Query("SELECT p.tag AS tag, COUNT(p.tag) AS tagCount FROM Policy p GROUP BY p.tag ORDER BY tagCount DESC")
    List<Object[]> findTopTags();
}