package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.MediumTextResponse;
import com.example.typing_speed_test.model.MediumText;

public class MediumTextConverter {

    public static MediumTextResponse toMediumTextResponse(MediumText text){
        if (text == null) return null;

        return MediumTextResponse.builder()
                .id(text.getId())
                .mediumText(text.getMediumText())
                .build();
    }

}
