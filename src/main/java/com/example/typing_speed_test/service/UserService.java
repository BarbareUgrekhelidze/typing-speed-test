package com.example.typing_speed_test.service;
import com.example.typing_speed_test.dto.UserRequest;
import com.example.typing_speed_test.dto.UserResponse;
import com.example.typing_speed_test.model.User;
import com.example.typing_speed_test.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import static com.example.typing_speed_test.utility.UserConverter.toUserResponse;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class UserService {

    private static final int MIN_PASS_LENGTH = 8;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    public UserResponse getUserById(Integer id){
        return toUserResponse(userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id: " + id + " does not exist")));
    }

    public UserResponse getUserByEmail(String email){
        return toUserResponse(userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("User with email: " + email + " does not exist")));
    }

    public UserResponse getUserByUsername(String username){
        return toUserResponse(userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("User with username: " + username + " does not exist")));
    }

    @Transactional
    public UserResponse createUser(UserRequest request){
        if (request.getUsername() == null || request.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username is required.");
        }

        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        if (request.getPassword() == null || request.getPassword().length() < MIN_PASS_LENGTH) {
            throw new IllegalArgumentException("Password must be at least 8 characters long!");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("User with this username already exists.");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        boolean emailExistsCheck = sendEmail(request.getEmail());
        if (!emailExistsCheck){
            throw new IllegalArgumentException("Email does not exist.");
        }

        String encodedPass = passwordEncoder.encode(request.getPassword());
        User newUser = User.builder()
                .email(request.getEmail())
                .username(request.getUsername())
                .password(encodedPass)
                .build();

        return toUserResponse(userRepository.save(newUser));
    }

    private boolean sendEmail(String email){
        boolean result = true;

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("bugre24@freeuni.edu.ge");
            message.setTo(email);
            message.setSubject("Typing Speed Test");
            message.setText("You successfully signed up on Typing Speed Test website");
            mailSender.send(message);
        }catch (Exception e){
            result = false;
        }

        return result;
    }

    @Transactional
    public UserResponse signInUser(UserRequest request){
        if (request.getEmail() == null) {
            throw new IllegalArgumentException("Email required");
        }

        if (request.getPassword() == null) {
            throw new IllegalArgumentException("Password required");
        }

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new NoSuchElementException("User with email: " + request.getEmail() + " does not exist"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password. Please try again.");
        }

        return toUserResponse(user);
    }

}
