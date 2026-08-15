package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.MediumTextResponse;
import com.example.typing_speed_test.dto.MediumWordResponse;
import com.example.typing_speed_test.model.MediumText;
import com.example.typing_speed_test.repository.MediumTextRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.example.typing_speed_test.utility.MediumTextConverter.toMediumTextResponse;

@Service
public class MediumTextService {

    @Autowired
    private MediumTextRepository mediumTextRepository;

    @Autowired
    private MediumWordService mediumWordService;

    @Transactional
    public MediumTextResponse getMediumText(){
        List<MediumWordResponse> words = mediumWordService.getRandomMediumWords();
        String text = "";

        for(int i = 0; i < words.size(); i++){
            text += words.get(i).getMediumWord();

            if (i != words.size()-1){
                text += " ";
            }
        }

        MediumText newText = mediumTextRepository.save(new MediumText(text));

        return toMediumTextResponse(newText);
    }

}
