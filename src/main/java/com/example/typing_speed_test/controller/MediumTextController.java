package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.MediumTextResponse;
import com.example.typing_speed_test.service.MediumTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medium")
@CrossOrigin(origins = "http://localhost:5173")
public class MediumTextController {

    @Autowired
    private MediumTextService mediumTextService;

    @GetMapping
    public MediumTextResponse getMediumText(){
        return mediumTextService.getMediumText();
    }

}
