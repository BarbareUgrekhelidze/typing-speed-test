package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.TimeMode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class TimeModeRepositorySeeder implements CommandLineRunner {
    private final TimeModeRepository timeModeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (timeModeRepository.count() > 0){
            return;
        }

        timeModeRepository.save(new TimeMode(15));
        timeModeRepository.save(new TimeMode(30));
        timeModeRepository.save(new TimeMode(60));
        timeModeRepository.save(new TimeMode(120));
    }
}
