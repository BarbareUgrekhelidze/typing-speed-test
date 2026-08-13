package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.EasyWordResponse;
import com.example.typing_speed_test.service.MediumWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/medium")
public class MediumWordController {
    @Autowired
    private MediumWordService mediumWordService;

    @GetMapping
    public List<EasyWordResponse> getRandomEasyWords(){
        return mediumWordService.getRandomMediumWords();
    }
}
