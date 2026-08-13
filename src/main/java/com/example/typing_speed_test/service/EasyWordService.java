package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.EasyWordResponse;
import com.example.typing_speed_test.repository.EasyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EasyWordService {

    private static final int NUM_WORDS = 100;

    @Autowired
    private EasyWordRepository easyWordRepository;

    public List<EasyWordResponse> getRandomEasyWords(){
        // todo
        return null;
    }

}
