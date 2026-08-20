package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.ScoreRequest;
import com.example.typing_speed_test.dto.ScoreResponse;
import com.example.typing_speed_test.model.Difficulty;
import com.example.typing_speed_test.model.Score;
import com.example.typing_speed_test.repository.*;
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
            return new ScoreResponse(score.getId(), score.getUser(), score.getDifficulty(), score.getTimeMode(), score.getWpm(), score.getTextId());
        }).collect(Collectors.toList());
    }

    public ScoreResponse getMaxScore(Integer userId, Integer difficulty){
        Optional<Score> scores = scoreRepository.findByUserId(userId);
        Score defaultScore = new Score();
        defaultScore.setWpm(Integer.MIN_VALUE);

        Score maxScore = scores.stream().filter(score -> score.getDifficulty().equals(difficulty))
                .reduce(defaultScore, (currScore, nextScore) -> {
            if (nextScore.getWpm() > currScore.getWpm()){
                return nextScore;
            }else{
                return currScore;
            }
        });

        return toScoreResponse(maxScore);
    }

    @Transactional
    public ScoreResponse addScore(ScoreRequest request){
        if (request.getUser() == null){
            throw new IllegalArgumentException("User is required.");
        }

        if (userRepository.findById(request.getUser().getId()) == null){
            throw new IllegalArgumentException("User with id: " + request.getUser().getId() + " does not exist.");
        }

        if (request.getDifficulty() == null){
            throw new IllegalArgumentException("Difficulty is required.");
        }

        if (difficultyRepository.findById(request.getDifficulty().getId()) == null){
            throw new IllegalArgumentException("Difficulty with id: " + request.getDifficulty().getId() + " does not exist.");
        }

        if (request.getTimeMode() == null){
            throw new IllegalArgumentException("TimeMode is required.");
        }

        if (timeModeRepository.findById(request.getTimeMode().getId()) == null){
            throw new IllegalArgumentException("TimeMode with id: " + request.getTimeMode().getId() + " does not exist.");
        }

        if (request.getWpm() == null){
            throw new IllegalArgumentException("Wpm is required.");
        }

        if (request.getTextId() == null){
            throw new IllegalArgumentException("Text is required.");
        }

        Optional<Difficulty> difficulty = difficultyRepository.findById(request.getDifficulty().getId());
        Difficulty diff = difficulty.get();

        if (diff.getDifficulty().equals("Easy")){
            if (easyTextRepository.findById(request.getTextId()) == null){
                throw new IllegalArgumentException("Easy Text with id: " + request.getTextId() + " does not exist.");
            }
        }

        if (diff.getDifficulty().equals("Medium")){
            if (mediumTextRepository.findById(request.getTextId()) == null){
                throw new IllegalArgumentException("Medium Text with id: " + request.getTextId() + " does not exist.");
            }
        }

        if (diff.getDifficulty().equals("Hard")){
            if (hardTextRepository.findById(request.getTextId()) == null){
                throw new IllegalArgumentException("Hard Text with id: " + request.getTextId() + " does not exist.");
            }
        }

        Score newScore = scoreRepository.save(new Score(request.getUser(), request.getDifficulty(), request.getTimeMode(), request.getWpm(), request.getTextId()));

        return toScoreResponse(newScore);
    }
}
