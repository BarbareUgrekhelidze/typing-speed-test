package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TextRequest {
    public Integer id;
    public String text;
}
