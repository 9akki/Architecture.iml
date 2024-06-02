package com.example.recommend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "policy")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String policyTitle;

    @Column(name = "pubdate")
    private Date policyDate;

    @Column(name = "tag")
    private String tag;

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

    public Date getPolicyDate() {
        return policyDate;
    }

    public void setPolicyDate(Date policyDate) {
        this.policyDate = policyDate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}