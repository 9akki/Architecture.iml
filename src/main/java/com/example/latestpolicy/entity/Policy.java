package com.example.latestpolicy.entity;

import javax.persistence.*;
import java.util.Date;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "policy")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String policyTitle;

    @Column(name = "pubdate")
    private LocalDate pubDate;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }
}