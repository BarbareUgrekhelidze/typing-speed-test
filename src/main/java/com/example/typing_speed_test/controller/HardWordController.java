package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.HardWordResponse;
import com.example.typing_speed_test.service.HardWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/hardWord")
public class HardWordController {
    @Autowired
    private HardWordService hardWordService;

    @GetMapping
    public List<HardWordResponse> getRandomHardWords(){
        return hardWordService.getRandomHardWords();
    }
}
