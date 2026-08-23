package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.HardTextResponse;
import com.example.typing_speed_test.service.HardTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hard")
@CrossOrigin(origins = "http://localhost:5173")
public class HardTextController {

    @Autowired
    private HardTextService hardTextService;

    @GetMapping
    public HardTextResponse getHardText(){
        return hardTextService.getHardText();
    }

}