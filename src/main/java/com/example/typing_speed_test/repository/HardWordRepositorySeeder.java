package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.HardWord;
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
public class HardWordRepositorySeeder implements CommandLineRunner {

    @Autowired
    private HardWordRepository hardWordRepository;

    @Override
    public void run(String... args) throws Exception {
        if (hardWordRepository.count() > 0) return;

        ClassPathResource resource = new ClassPathResource("words/hardWords.json");
        InputStream is = resource.getInputStream();

        WordParser wordParser = new WordParser();
        List<String> words = wordParser.getWords(is);

        for(int i = 0; i < words.size(); i++){
            hardWordRepository.save(new HardWord(words.get(i).toLowerCase()));
        }
    }
}
