package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.HardTextResponse;
import com.example.typing_speed_test.dto.HardWordResponse;
import com.example.typing_speed_test.model.HardText;
import com.example.typing_speed_test.repository.HardTextRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.example.typing_speed_test.utility.HardTextConverter.toHardTextResponse;


@Service
public class HardTextService {

    @Autowired
    private HardTextRepository hardTextRepository;

    @Autowired
    private HardWordService hardWordService;

    @Transactional
    public HardTextResponse getHardText(){
        List<HardWordResponse> words = hardWordService.getRandomHardWords();
        String text = "";

        for(int i = 0; i < words.size(); i++){
            text += words.get(i).getHardWord();

            if (i != words.size()-1){
                text += " ";
            }
        }

        HardText newText = hardTextRepository.save(new HardText(text));

        return toHardTextResponse(newText);
    }

}
