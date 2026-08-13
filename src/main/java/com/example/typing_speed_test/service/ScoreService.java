package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.ScoreResponse;
import com.example.typing_speed_test.model.Score;
import com.example.typing_speed_test.repository.DifficultyRepository;
import com.example.typing_speed_test.repository.ScoreRepository;
import com.example.typing_speed_test.repository.TimeModeRepository;
import com.example.typing_speed_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.example.typing_speed_test.utility.ScoreConverter.toScoreResponse;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeModeRepository timeMoreRepository;

    @Autowired
    private DifficultyRepository difficultyRepository;

    public List<ScoreResponse> getScoresByUser(Integer userId){
        Optional<Score> scores = scoreRepository.findByUserId(userId);

        return scores.stream().map(score -> {
            return new ScoreResponse(score.getId(), score.getUser(), score.getDifficulty(), score.getTimeMode(), score.getWpm());
        }).collect(Collectors.toList());
    }

    public ScoreResponse getMaxScore(Integer userId){
        Optional<Score> scores = scoreRepository.findByUserId(userId);
        Score defaultScore = new Score();
        defaultScore.setWpm(Integer.MIN_VALUE);

        Score maxScore = scores.stream().reduce(defaultScore, (currScore, nextScore) -> {
            if (nextScore.getWpm() > currScore.getWpm()){
                return nextScore;
            }else{
                return currScore;
            }
        });

        return toScoreResponse(maxScore);
    }
}
