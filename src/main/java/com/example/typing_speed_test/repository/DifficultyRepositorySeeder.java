package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.Difficulty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DifficultyRepositorySeeder implements CommandLineRunner {
    private final DifficultyRepository difficultyRepository;

    @Override
    public void run(String... args) throws Exception {
        if (difficultyRepository.count() > 0){
            return;
        }

        difficultyRepository.save(new Difficulty("Easy"));
        difficultyRepository.save(new Difficulty("Medium"));
        difficultyRepository.save(new Difficulty("Hard"));
    }
}