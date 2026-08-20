package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Scores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScoreID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "DifficultyID", nullable = false)
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "TimeID", nullable = false)
    private TimeMode timeMode;

    @Column(name = "Wmp", nullable = false)
    private Integer wpm;

    @Column(name = "TextID", nullable = false)
    private Integer textId;

    public Score(User user, Difficulty difficulty, TimeMode timeMode, Integer wpm, Integer textId){
        this.user = user;
        this.difficulty = difficulty;
        this.timeMode = timeMode;
        this.wpm = wpm;
        this.textId = textId;
    }
}