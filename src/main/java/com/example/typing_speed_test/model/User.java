package com.example.typing_speed_test.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer id;

    @Email
    @Column(name = "UserEmail", nullable = false, length = 150)
    private String email;

    @Column(name = "UserName", nullable = false, length = 100)
    private String username;

    @Column(name = "UserPassword", nullable = false, length = 500)
    private String password;

    public User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
