package com.study.websocket.services;

import com.study.websocket.entity.ChatRoom;
import com.study.websocket.entity.Message;
import com.study.websocket.entity.User;
import com.study.websocket.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessagesByChatRoom(ChatRoom chatRoom) {
        return messageRepository.findByChatRoomOrderByCreatedAtAsc(chatRoom);
    }

    public Message createMessage(User user, ChatRoom chatRoom, String content) {
        Message userMessage = Message.newMessage(user, chatRoom, content);
        messageRepository.save(userMessage);

        return userMessage;
    }
}
