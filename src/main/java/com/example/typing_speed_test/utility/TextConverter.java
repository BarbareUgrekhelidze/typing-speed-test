package com.example.typing_speed_test.utility;
import com.example.typing_speed_test.dto.TextResponse;
import com.example.typing_speed_test.model.Text;

public class TextConverter {
    public static TextResponse toTextResponse(Text text){
        if (text == null) return null;

        return TextResponse.builder()
                .id(text.getId())
                .text(text.getText())
                .build();
    }
}
