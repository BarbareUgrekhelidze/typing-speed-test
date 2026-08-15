package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.EasyTextResponse;
import com.example.typing_speed_test.dto.EasyWordResponse;
import com.example.typing_speed_test.model.EasyText;
import com.example.typing_speed_test.repository.EasyTextRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.example.typing_speed_test.utility.EasyTextConverter.toEasyTextResponse;

@Service
public class EasyTextService {

    @Autowired
    private EasyTextRepository easyTextRepository;

    @Autowired
    private EasyWordService easyWordService;

    @Transactional
    public EasyTextResponse getEasyText(){
        List<EasyWordResponse> words = easyWordService.getRandomEasyWords();
        String text = "";

        for(int i = 0; i < words.size(); i++){
            text += words.get(i).getEasyWord();

            if (i != words.size()-1){
                text += " ";
            }
        }

        EasyText newText = easyTextRepository.save(new EasyText(text));

        return toEasyTextResponse(newText);
    }

}
