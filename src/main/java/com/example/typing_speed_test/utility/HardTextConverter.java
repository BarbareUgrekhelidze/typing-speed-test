package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.HardTextResponse;
import com.example.typing_speed_test.model.HardText;

public class HardTextConverter {

    public static HardTextResponse toHardTextResponse(HardText text){
        if (text == null) return null;

        return HardTextResponse.builder()
                .id(text.getId())
                .hardText(text.getHardText())
                .build();
    }

}
