package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.HardWordResponse;
import com.example.typing_speed_test.model.HardWord;

public class HardWordConverter {
    public static HardWordResponse toHardWordResponse(HardWord word){
        if (word == null) return null;

        return HardWordResponse.builder()
                .id(word.getId())
                .hardWord(word.getHardWord())
                .build();
    }
}
