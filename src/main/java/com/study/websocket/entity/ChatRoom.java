package com.study.websocket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "chat_room")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinTable(
            name = "user_chatroom",
            joinColumns = @JoinColumn(name = "chatroom_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private User user;
    @OneToMany
    private List<Message> messages;
    private Instant created_at;

    public ChatRoom() {
    }

    public ChatRoom(
            final Long id,
            final String name,
            final User user,
            final List<Message> messages,
            final Instant created_at
    ) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.messages = messages;
        this.created_at = created_at;
    }

    public static ChatRoom newChatRoom(
            final String name,
            final User user
    ){
        return new ChatRoom(0L, name, user, List.of(), Instant.now());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public List<Message> getMessages() {
        return messages;
    }
}