package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.ScoreResponse;
import com.example.typing_speed_test.model.Score;

public class ScoreConverter {

    public static ScoreResponse toScoreResponse(Score score){
        if (score == null) return null;

        return ScoreResponse.builder()
                .id(score.getId())
                .userId(score.getUser() != null ? score.getUser().getId() : null)
                .difficultyId(score.getDifficulty() != null ? score.getDifficulty().getId() : null)
                .timeModeId(score.getTimeMode() != null ? score.getTimeMode().getId() : null)
                .wpm(score.getWpm())
                .textId(score.getTextId())
                .build();
    }

}
