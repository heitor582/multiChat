package com.study.websocket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Instant created_at;

    public User() {
    }

    public User(
            final Long id,
            final String username,
            final String password,
            final Instant created_at
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.created_at = created_at;
    }

    public static User newUser(
            final String username,
            final String password
    ){
        return new User(
                0L, username, password, Instant.now()
        );
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Instant getCreated_at() {
        return created_at;
    }
}