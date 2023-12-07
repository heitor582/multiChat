package com.study.websocket.dto;

import com.study.websocket.entity.ChatRoom;

public record ChatRoomListDto(
        Long id,
        String name
) {
    public static ChatRoomListDto from(final ChatRoom chatRoom) {
        return new ChatRoomListDto(chatRoom.getId(), chatRoom.getName());
    }
}
