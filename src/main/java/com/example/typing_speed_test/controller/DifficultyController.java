package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.DifficultyResponse;
import com.example.typing_speed_test.service.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/difficulty")
public class DifficultyController {
    @Autowired
    private DifficultyService difficultyService;

    @GetMapping("id/{id}")
    public DifficultyResponse getDifficultyById(@PathVariable Integer id) {
        return difficultyService.getDifficultyById(id);
    }

    @GetMapping("level/{difficulty}")
    public DifficultyResponse getDifficultyByDifficulty(@PathVariable String difficulty){
        return difficultyService.getDifficultyByDifficulty(difficulty);
    }

    @GetMapping
    public List<DifficultyResponse> getAllDifficulties(){
        return difficultyService.getAllDifficulties();
    }
}