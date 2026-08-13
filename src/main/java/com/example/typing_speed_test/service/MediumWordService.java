package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.EasyWordResponse;
import com.example.typing_speed_test.repository.MediumWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MediumWordService {
    private static final int NUM_WORDS = 100;

    @Autowired
    private MediumWordRepository mediumWordRepository;

    public List<EasyWordResponse> getRandomMediumWords(){
        // todo
        return null;
    }
}
