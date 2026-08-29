package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.ScoreRequest;
import com.example.typing_speed_test.dto.ScoreResponse;
import com.example.typing_speed_test.model.Difficulty;
import com.example.typing_speed_test.model.Score;
import com.example.typing_speed_test.model.TimeMode;
import com.example.typing_speed_test.model.User;
import com.example.typing_speed_test.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    private TimeModeRepository timeModeRepository;

    @Autowired
    private DifficultyRepository difficultyRepository;

    @Autowired
    private EasyTextRepository easyTextRepository;

    @Autowired
    private MediumTextRepository mediumTextRepository;

    @Autowired
    private HardTextRepository hardTextRepository;

    public List<ScoreResponse> getScoresByUser(Integer userId){
        Optional<Score> scores = scoreRepository.findByUserId(userId);

        return scores.stream().map(score -> {
            return toScoreResponse(score);
        }).collect(Collectors.toList());
    }

    public ScoreResponse getMaxScore(Integer userId){
        Score maxScore = scoreRepository.findFirstByUserIdOrderByWpmDesc(userId)
                .orElseThrow(() -> new EntityNotFoundException("No max Score was found for user with id: " + userId));

        return toScoreResponse(maxScore);
    }

    @Transactional
    public ScoreResponse addScore(ScoreRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User with id: " + request.getUserId() + " does not exist."));
        Difficulty diff = difficultyRepository.findById(request.getDifficultyId())
                .orElseThrow(() -> new IllegalArgumentException("Difficulty with id: " + request.getDifficultyId() + " does not exist."));
        TimeMode time = timeModeRepository.findById(request.getTimeModeId())
                .orElseThrow(() -> new IllegalArgumentException("TimeMode with id: " + request.getTimeModeId() + " does not exist."));

        if (request.getWpm() == null){
            throw new IllegalArgumentException("Wpm is required.");
        }

        if (request.getTextId() == null){
            throw new IllegalArgumentException("Text is required.");
        }

        boolean exists = false;
        String level = diff.getDifficulty() == null ? "" : diff.getDifficulty();

        if (level.equalsIgnoreCase("Easy")){
            exists = easyTextRepository.existsById(request.getTextId());
        }else if (level.equalsIgnoreCase("Medium")){
            exists = mediumTextRepository.existsById(request.getTextId());
        }else if (level.equalsIgnoreCase("Hard")){
            exists = hardTextRepository.existsById(request.getTextId());
        }

        if (!exists){
            throw new IllegalArgumentException("Text with id: " + request.getTextId() + " does not exist.");
        }

        Score newScore = scoreRepository.save(new Score(
                user,
                diff,
                time,
                request.getWpm(),
                request.getTextId()
        ));

        return toScoreResponse(newScore);
    }
}
