package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Difficulty")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DifficultyID")
    private Integer id;

    @Column(name="Difficulty")
    private String difficulty;

    public Difficulty(String difficulty){
        this.difficulty = difficulty;
    }
}
