package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EasyWords")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EasyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EasyWordID")
    private Integer id;

    @Column(name="EasyWord", nullable = false)
    private String easyWord;
}
