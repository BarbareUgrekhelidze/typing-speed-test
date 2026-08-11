package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.Duration;

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

    @Column(name = "Time")
    private Duration time;

    public TimeMode(Duration time){
        this.time = time;
    }
}