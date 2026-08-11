package com.example.typing_speed_test.utility;

import com.example.typing_speed_test.dto.DifficultyResponse;
import com.example.typing_speed_test.model.Difficulty;

public class DifficultyConverter {

    public static DifficultyResponse toDifficultyResponse (Difficulty difficulty){
        if (difficulty == null) return null;

        return DifficultyResponse.builder()
                .id(difficulty.getId())
                .difficulty(difficulty.getDifficulty())
                .build();
    }

}
