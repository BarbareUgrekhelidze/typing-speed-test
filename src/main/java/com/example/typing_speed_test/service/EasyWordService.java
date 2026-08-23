package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.EasyWordResponse;
import com.example.typing_speed_test.model.EasyWord;
import com.example.typing_speed_test.repository.EasyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.typing_speed_test.utility.EasyWordConverter.toEasyWordResponse;

@Service
public class EasyWordService {

    private static final int NUM_WORDS = 100;

    @Autowired
    private EasyWordRepository easyWordRepository;

    public List<EasyWordResponse> getRandomEasyWords(){
        List<EasyWord> result = new ArrayList<>();

        for(int i = 0; i < NUM_WORDS; i++){
            Optional<EasyWord> easyWord = easyWordRepository.findRandomEasyWord();

            if (easyWord != null){
                result.add(easyWord.get());
            }
        }

        return result.stream().map(word -> toEasyWordResponse(word)).collect(Collectors.toList());
    }

}
