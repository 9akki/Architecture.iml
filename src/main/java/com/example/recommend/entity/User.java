package com.example.recommend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "User_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "User_sub")
    private String userSub;

    // getters and setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSub() {
        return userSub;
    }

    public void setUserSub(String userSub) {
        this.userSub = userSub;
    }
}

