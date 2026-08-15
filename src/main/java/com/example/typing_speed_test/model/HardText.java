package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HardTexts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HardText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="HardTextID")
    private Integer id;

    @Column(name="HardText", nullable = false, length = 2000)
    private String hardText;

    public HardText(String hardText){
        this.hardText = hardText;
    }
}
