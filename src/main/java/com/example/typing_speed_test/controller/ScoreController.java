package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.ScoreResponse;
import com.example.typing_speed_test.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/allScores/{userId}")
    public List<ScoreResponse> getScoresByUserId(@PathVariable Integer userId){
        return scoreService.getScoresByUser(userId);
    }

    @GetMapping("/maxScore/{userId}")
    public ScoreResponse getMaxScoreByUserId(@PathVariable Integer userId, Integer difficulty){
        return scoreService.getMaxScore(userId, difficulty);
    }
}