package com.study.websocket.dto;

import com.study.websocket.entity.User;

public record UserDto(
        Long id,
        String username
) {
    public static UserDto from(final User user){
        return  new UserDto(user.getId(), user.getUsername());
    }
}
