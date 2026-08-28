package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DifficultyResponse {
    private Integer id;
    private String difficulty;
}
