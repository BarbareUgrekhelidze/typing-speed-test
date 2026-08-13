package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.MediumWordResponse;
import com.example.typing_speed_test.model.MediumWord;
import com.example.typing_speed_test.repository.MediumWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import static com.example.typing_speed_test.utility.MediumWordConverter.toMediumWordResponse;

@Service
public class MediumWordService {
    private static final int NUM_WORDS = 100;

    @Autowired
    private MediumWordRepository mediumWordRepository;

    public List<MediumWordResponse> getRandomMediumWords(){
        List<MediumWord> result = new ArrayList<>();

        long randomNumber = 0;
        long maxCount = mediumWordRepository.count();
        Random random = new Random();
        for(int i = 0; i < NUM_WORDS; i++){
            randomNumber = random.nextLong(1, maxCount+1);
            Optional<MediumWord> mediumWord = mediumWordRepository.findById((int)randomNumber);

            if (mediumWord != null){
                result.add(mediumWord.get());
            }
        }

        return result.stream().map(word -> toMediumWordResponse(word)).collect(Collectors.toList());
    }
}
