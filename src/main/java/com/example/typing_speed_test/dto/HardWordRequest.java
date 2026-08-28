package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HardWordRequest {
    private Integer id;
    private String hardWord;
}
