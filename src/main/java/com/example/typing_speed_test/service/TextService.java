package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.TextResponse;
import com.example.typing_speed_test.model.Text;
import com.example.typing_speed_test.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.typing_speed_test.utility.TextConverter.toTextResponse;

@Service
public class TextService {

    @Autowired
    private TextRepository textRepository;

    public TextResponse getRandomText(){
        return toTextResponse(new Text(""));
    }

}
