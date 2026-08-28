package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EasyWordResponse {
    private Integer id;
    private String easyWord;
}
