package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.TextResponse;
import com.example.typing_speed_test.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/texts")
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping
    public TextResponse getRandomText(){
        return textService.getRandomText();
    }

}
