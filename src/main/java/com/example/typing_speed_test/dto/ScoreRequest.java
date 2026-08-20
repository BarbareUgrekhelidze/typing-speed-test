package com.example.typing_speed_test.dto;
import com.example.typing_speed_test.model.Difficulty;
import com.example.typing_speed_test.model.TimeMode;
import com.example.typing_speed_test.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScoreRequest {
    public Integer id;
    public User user;
    public Difficulty difficulty;
    public TimeMode timeMode;
    public Integer wpm;
    public Integer textId;
}
