package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.EasyTextResponse;
import com.example.typing_speed_test.service.EasyTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/easy")
@CrossOrigin(origins = "http://localhost:5173")
public class EasyTextController {

    @Autowired
    private EasyTextService easyTextService;

    @GetMapping
    public EasyTextResponse getEasyText(){
        return easyTextService.getEasyText();
    }

}
