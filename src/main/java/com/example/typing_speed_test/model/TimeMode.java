package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TimeMode")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TimeID")
    private Integer id;

    @Column(name = "Time", nullable = false)
    private Integer time;

    public TimeMode(Integer time){
        this.time = time;
    }
}