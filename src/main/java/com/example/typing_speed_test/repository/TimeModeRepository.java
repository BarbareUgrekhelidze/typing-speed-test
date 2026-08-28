package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.TimeMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.Duration;
import java.util.Optional;

@Repository
public interface TimeModeRepository extends JpaRepository<TimeMode, Integer> {
    Optional<TimeMode> findByTime(Integer duration);
}
