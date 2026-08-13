package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.MediumWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MediumWordRepository extends JpaRepository<MediumWord, Integer> {
    Optional<MediumWord> findByMediumWordId(Integer id);
}
