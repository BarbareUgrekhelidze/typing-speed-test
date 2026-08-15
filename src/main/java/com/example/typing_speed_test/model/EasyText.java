package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EasyTexts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EasyText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EasyTextID")
    private Integer id;

    @Column(name="EasyText", nullable = false)
    private String easyText;

    public EasyText(String easyText){
        this.easyText = easyText;
    }

}
