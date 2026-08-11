package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Integer> {
    Optional<Difficulty> findByDifficulty(String difficulty);
}
