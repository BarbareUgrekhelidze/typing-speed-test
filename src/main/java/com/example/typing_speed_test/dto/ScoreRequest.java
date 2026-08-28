package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScoreRequest {
    private Integer id;
    private Integer userId;
    private Integer difficultyId;
    private Integer timeModeId;
    private Integer wpm;
    private Integer textId;
}
