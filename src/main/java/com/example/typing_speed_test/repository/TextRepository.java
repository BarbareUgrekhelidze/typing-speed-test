package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TextRepository extends JpaRepository<Text, Integer> {
    Optional<Text> findById(Integer id);
}
