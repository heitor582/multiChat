package com.study.websocket.services;

import com.study.websocket.dto.ChatRoomListDto;
import com.study.websocket.entity.ChatRoom;
import com.study.websocket.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(final ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public Optional<ChatRoom> getChatRoomById(final Long chatRoomId) {
        return chatRoomRepository.findById(chatRoomId);
    }

    public List<ChatRoomListDto> getAllChatRooms() {
        return chatRoomRepository.findAll().stream().map(ChatRoomListDto::from).toList();
    }

    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public void deleteChatRoom(Long chatRoomId) {
        chatRoomRepository.deleteById(chatRoomId);
    }
}
