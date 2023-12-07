package com.study.websocket.controller;

import com.study.websocket.dto.ChatRoomListDto;
import com.study.websocket.entity.ChatRoom;
import com.study.websocket.services.ChatRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(final ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    @GetMapping("/{chatRoomId}")
    public ResponseEntity<ChatRoom> getChatRoom(@PathVariable Long chatRoomId) {
        Optional<ChatRoom> chatRoom = chatRoomService.getChatRoomById(chatRoomId);
        return chatRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ChatRoomListDto>> getAllChatRooms() {
        List<ChatRoomListDto> chatRooms = chatRoomService.getAllChatRooms();
        return ResponseEntity.ok(chatRooms);
    }

    @PostMapping
    public ResponseEntity<ChatRoom> createChatRoom(@RequestBody ChatRoom chatRoom) {
        ChatRoom newChatRoom = chatRoomService.createChatRoom(chatRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(newChatRoom);
    }

    @DeleteMapping("/{chatRoomId}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Long chatRoomId) {
        chatRoomService.deleteChatRoom(chatRoomId);
        return ResponseEntity.noContent().build();
    }
}
