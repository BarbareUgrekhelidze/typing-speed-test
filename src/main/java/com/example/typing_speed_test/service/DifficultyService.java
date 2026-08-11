package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.DifficultyResponse;
import com.example.typing_speed_test.model.Difficulty;
import com.example.typing_speed_test.repository.DifficultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import static com.example.typing_speed_test.utility.DifficultyConverter.toDifficultyResponse;

@Service
public class DifficultyService {
    @Autowired
    private DifficultyRepository difficultyRepository;

    public DifficultyResponse getDifficultyById(Integer id){
        return toDifficultyResponse(difficultyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Difficulty with id: " + id + " does not exist.")));
    }

    public DifficultyResponse getDifficultyByDifficulty(String difficulty){
        return toDifficultyResponse(difficultyRepository.findByDifficulty(difficulty).orElseThrow(() -> new NoSuchElementException("Difficulty with name: " + difficulty + " does not exist.")));
    }

    public List<DifficultyResponse> getAllDifficulties(){
        List<Difficulty> difficulties = difficultyRepository.findAll();

        return difficulties.stream().map(difficulty ->
                {
                    return new DifficultyResponse(difficulty.getId(), difficulty.getDifficulty());
                })
                .collect(Collectors.toList());
    }
}
