package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    public String username;
    public String email;
    public String password;
}
