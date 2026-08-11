package com.example.typing_speed_test.utility;

import com.example.typing_speed_test.dto.TimeModeResponse;
import com.example.typing_speed_test.model.TimeMode;

public class TimeModeConverter {
    public static TimeModeResponse toTimeModeResponse(TimeMode timeMode){
        if (timeMode == null) return null;

        return TimeModeResponse.builder()
                .id(timeMode.getId())
                .time(timeMode.getTime())
                .build();
    }
}
