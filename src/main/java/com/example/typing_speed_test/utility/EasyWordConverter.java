package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.EasyWordResponse;
import com.example.typing_speed_test.model.EasyWord;

public class EasyWordConverter {
    public static EasyWordResponse toEasyWordResponse(EasyWord word){
        if (word == null) return null;

        return EasyWordResponse.builder()
                .id(word.getId())
                .easyWord(word.getEasyWord())
                .build();
    }
}
