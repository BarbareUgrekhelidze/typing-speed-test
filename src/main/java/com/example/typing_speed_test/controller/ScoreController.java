package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.ScoreRequest;
import com.example.typing_speed_test.dto.ScoreResponse;
import com.example.typing_speed_test.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/scores")
@CrossOrigin(origins = "http://localhost:5173")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/allScores/{userId}")
    public List<ScoreResponse> getScoresByUserId(@PathVariable Integer userId){
        return scoreService.getScoresByUser(userId);
    }

    @GetMapping("/maxScore/{userId}")
    public ScoreResponse getMaxScoreByUserId(@PathVariable Integer userId){
        return scoreService.getMaxScore(userId);
    }

    @PostMapping("/newScore")
    public ResponseEntity<?> addNewScore(@RequestBody ScoreRequest request){
        try {
            ScoreResponse response = scoreService.addScore(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.println("=== SCORE CREATION FAILED ===");
            e.printStackTrace();
            System.err.println("=============================");

            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

}