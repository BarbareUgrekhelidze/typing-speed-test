package com.example.typing_speed_test.dto;
import lombok.*;
import java.time.Duration;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeModeRequest {
    public Integer id;
    public Duration time;
}
