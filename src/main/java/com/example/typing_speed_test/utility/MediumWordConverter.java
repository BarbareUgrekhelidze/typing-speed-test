package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.MediumWordResponse;
import com.example.typing_speed_test.model.MediumWord;

public class MediumWordConverter {
    public static MediumWordResponse toMediumWordResponse(MediumWord word){
        if (word == null) return null;

        return MediumWordResponse.builder()
                .id(word.getId())
                .mediumWord(word.getMediumWord())
                .build();
    }
}
