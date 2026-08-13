package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.EasyWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EasyWordRepository extends JpaRepository<EasyWord, Integer> {
}
