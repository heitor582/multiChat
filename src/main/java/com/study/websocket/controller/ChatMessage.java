package com.study.websocket.controller;

import com.study.websocket.dto.UserDto;

public record ChatMessage(UserDto user, Long chatRoomId, String content) {
}