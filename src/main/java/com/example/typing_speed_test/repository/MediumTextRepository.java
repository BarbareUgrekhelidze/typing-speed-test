package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.MediumText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumTextRepository extends JpaRepository<MediumText, Integer> {
}
