package com.hutech.javas3d3.Entities;

import com.hutech.javas3d3.Untils.SHA512Hashing;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // Constructor, getters, and setters
    public User() {
        // Default constructor
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = SHA512Hashing.hash(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
