package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.EasyWord;
import com.example.typing_speed_test.model.HardWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HardWordRepository extends JpaRepository<HardWord, Integer> {
    Optional<HardWord> findByHardWordId(Integer id);
}
