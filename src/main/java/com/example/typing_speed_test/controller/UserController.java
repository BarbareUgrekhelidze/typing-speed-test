package com.example.typing_speed_test.controller;
import com.example.typing_speed_test.dto.UserRequest;
import com.example.typing_speed_test.dto.UserResponse;
import com.example.typing_speed_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public UserResponse getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public UserResponse getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/username/{username}")
    public UserResponse getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request){
       return userService.createUser(request);
    }

    @PostMapping("/login")
    public UserResponse signInUser(@RequestBody UserRequest request){
        return userService.signInUser(request);
    }
}
