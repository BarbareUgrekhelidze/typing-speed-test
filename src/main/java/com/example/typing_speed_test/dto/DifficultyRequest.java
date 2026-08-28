package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DifficultyRequest {
    private Integer id;
    private String difficulty;
}
