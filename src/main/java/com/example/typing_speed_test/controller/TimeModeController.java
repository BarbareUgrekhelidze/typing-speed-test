package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.TimeModeResponse;
import com.example.typing_speed_test.service.TimeModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/duration")
public class TimeModeController {
    @Autowired
    private TimeModeService timeModeService;

    @GetMapping("/id/{id}")
    public TimeModeResponse getTimeModeById(@PathVariable Integer id){
        return timeModeService.getTimeModeById(id);
    }

    @GetMapping("/duration/{time}")
    public TimeModeResponse getTimeModeByTime(@PathVariable Duration time){
        return timeModeService.getTimeModeByTime(time);
    }

    @GetMapping
    public List<TimeModeResponse> getAllTimeModes(){
        return timeModeService.getAllTimeModes();
    }
}