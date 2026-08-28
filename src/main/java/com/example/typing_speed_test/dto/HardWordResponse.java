package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HardWordResponse {
    private Integer id;
    private String hardWord;
}
