package com.study.websocket.services;

import com.study.websocket.controller.ChatMessage;
import com.study.websocket.dto.UserDto;
import com.study.websocket.entity.ChatRoom;
import com.study.websocket.entity.Message;
import com.study.websocket.entity.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ChatService {

    private final MessageService messageService;
    private final UserService userService;
    private final ChatRoomService chatRoomService;

    public ChatService(
           final MessageService messageService,
           final UserService userService,
           final ChatRoomService chatRoomService
    ) {
        this.messageService = messageService;
        this.userService = userService;
        this.chatRoomService = chatRoomService;
    }

    public List<ChatMessage> handleNewMessage(final ChatMessage chatMessage) throws IOException {
        ChatRoom chatRoom = chatRoomService.getChatRoomById(chatMessage.chatRoomId()).get();
        User user = chatRoom.getUser();

        Message userMessageContent = messageService.createMessage(user, chatRoom, chatMessage.content());

        ChatMessage userWebSocketMessage = new ChatMessage(UserDto.from(user), chatRoom.getId(), userMessageContent.getContent());

        return List.of(userWebSocketMessage);
    }
}
