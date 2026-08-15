package com.example.typing_speed_test.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EasyTextRequest {
    public Integer id;
    public String easyText;
}
