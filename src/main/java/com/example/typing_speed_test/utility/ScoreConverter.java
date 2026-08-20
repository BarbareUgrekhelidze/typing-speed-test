package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.ScoreResponse;
import com.example.typing_speed_test.model.Score;

public class ScoreConverter {

    public static ScoreResponse toScoreResponse(Score score){
        if (score == null) return null;

        return ScoreResponse.builder()
                .id(score.getId())
                .user(score.getUser())
                .difficulty(score.getDifficulty())
                .timeMode(score.getTimeMode())
                .wpm(score.getWpm())
                .textId(score.getTextId())
                .build();
    }

}
