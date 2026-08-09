package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.UserResponse;
import com.example.typing_speed_test.model.User;

public class UserConverter {
    public static UserResponse toUserResponse(User user){
        if (user == null) return null;

        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
