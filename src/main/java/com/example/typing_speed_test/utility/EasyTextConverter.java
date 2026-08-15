package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.EasyTextResponse;
import com.example.typing_speed_test.model.EasyText;

public class EasyTextConverter {
    public static EasyTextResponse toEasyTextResponse(EasyText text){
        if (text == null) return null;

        return EasyTextResponse.builder()
                .id(text.getId())
                .easyText(text.getEasyText())
                .build();
    }
}
