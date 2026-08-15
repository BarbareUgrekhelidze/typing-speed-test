package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MediumWords")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MediumWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MediumWordID")
    private Integer id;

    @Column(name="MediumWord", nullable = false)
    private String mediumWord;

    public MediumWord(String mediumWord){
        this.mediumWord = mediumWord;
    }
}
