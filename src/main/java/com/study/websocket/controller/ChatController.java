package com.study.websocket.controller;

import com.study.websocket.services.ChatService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(final ChatService chatService, final SimpMessagingTemplate simpMessagingTemplate) {
        this.chatService = chatService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    // /app/chat
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/messages/{roomId}")
    public List<ChatMessage> handleMessage(@DestinationVariable String roomId, @Payload ChatMessage message) throws IOException {
        return chatService.handleNewMessage(message);
    }
}
