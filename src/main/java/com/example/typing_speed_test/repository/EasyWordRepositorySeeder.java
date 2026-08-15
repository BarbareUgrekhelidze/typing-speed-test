package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.EasyWord;
import com.example.typing_speed_test.parse.WordParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class EasyWordRepositorySeeder implements CommandLineRunner {

    @Autowired
    private EasyWordRepository easyWordRepository;

    @Override
    public void run(String... args) throws Exception {
        if (easyWordRepository.count() > 0) return;

        ClassPathResource resource = new ClassPathResource("words/easyWords.json");
        InputStream is = resource.getInputStream();

        WordParser wordParser = new WordParser();
        List<String> words = wordParser.getWords(is);

        for(int i = 0; i < words.size(); i++){
            easyWordRepository.save(new EasyWord(words.get(i)));
        }
    }
}
