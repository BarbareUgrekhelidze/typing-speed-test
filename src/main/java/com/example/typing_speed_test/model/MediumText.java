package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MediumTexts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MediumText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MediumTextID")
    private Integer id;

    @Column(name="MediumText", nullable = false, length = 2000)
    private String mediumText;

    public MediumText(String mediumText){
        this.mediumText = mediumText;
    }

}
