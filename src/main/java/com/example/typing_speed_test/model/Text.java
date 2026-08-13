package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Texts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TextID")
    private Integer id;

    @Column(name = "Text", nullable = false)
    private String text;

    public Text(String text){
        this.text = text;
    }
}