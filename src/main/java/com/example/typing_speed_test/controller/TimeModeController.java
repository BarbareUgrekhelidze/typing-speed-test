package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.TimeModeResponse;
import com.example.typing_speed_test.service.TimeModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/duration")
@CrossOrigin(origins = "http://localhost:5173")
public class TimeModeController {
    @Autowired
    private TimeModeService timeModeService;

    @GetMapping("/id/{id}")
    public TimeModeResponse getTimeModeById(@PathVariable Integer id){
        return timeModeService.getTimeModeById(id);
    }

    @GetMapping("seconds/{time}")
    public TimeModeResponse getTimeModeByTime(@PathVariable Integer time){
        return timeModeService.getTimeModeByTime(time);
    }

    @GetMapping
    public List<TimeModeResponse> getAllTimeModes(){
        return timeModeService.getAllTimeModes();
    }
}