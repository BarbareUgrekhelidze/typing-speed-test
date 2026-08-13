package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.EasyWordResponse;
import com.example.typing_speed_test.repository.HardWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HardWordService {

    private static final int NUM_WORDS = 100;

    @Autowired
    private HardWordRepository hardWordRepository;

    public List<EasyWordResponse> getRandomHardWords(){
        // todo
        return null;
    }
}
