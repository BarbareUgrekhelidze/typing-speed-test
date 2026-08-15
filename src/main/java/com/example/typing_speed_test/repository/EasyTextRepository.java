package com.example.typing_speed_test.repository;
import com.example.typing_speed_test.model.EasyText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EasyTextRepository extends JpaRepository<EasyText, Integer> {
}
