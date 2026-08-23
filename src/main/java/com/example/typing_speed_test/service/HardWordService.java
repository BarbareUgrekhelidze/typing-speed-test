package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.HardWordResponse;
import com.example.typing_speed_test.model.HardWord;
import com.example.typing_speed_test.repository.HardWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.example.typing_speed_test.utility.HardWordConverter.toHardWordResponse;

@Service
public class HardWordService {

    private static final int NUM_WORDS = 100;

    @Autowired
    private HardWordRepository hardWordRepository;

    public List<HardWordResponse> getRandomHardWords(){
        List<HardWord> result = new ArrayList<>();

        for(int i = 0; i < NUM_WORDS; i++){
            Optional<HardWord> hardWord = hardWordRepository.findRandomHardWord();

            if (hardWord != null){
                result.add(hardWord.get());
            }
        }

        return result.stream().map(word -> toHardWordResponse(word)).collect(Collectors.toList());
    }
}
