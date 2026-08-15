package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HardWords")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HardWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="HardWordID")
    private Integer id;

    @Column(name="HardWord", nullable = false)
    private String hardWord;

    public HardWord(String hardWord){
        this.hardWord = hardWord;
    }
}
