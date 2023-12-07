package com.spring.security.controller;

import com.spring.security.dto.UserDTO;
import com.spring.security.entity.User;
import com.spring.security.exception.NotFoundException;
import com.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registers")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO user) {
        try {
            if( this.userService.registerUser(user)) {
                return ResponseEntity.ok("Register Successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Register failed");
            }
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
        }
    };

    @GetMapping("/")
    public  ResponseEntity<List<User>> getUserList(){
        try {List<User>getUsers = this.userService.getAllUser();
            return new ResponseEntity<>(getUsers, HttpStatus.OK);}
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    };

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        try{

            boolean isAuthenticated = this.userService.login(userDTO);
            if (isAuthenticated) {
                Optional<User> userDTO1 = this.userService.findByEmail(userDTO.getEmail());
                return ResponseEntity.ok(userDTO1);
            } else {
                // Handle the case where authentication fails
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
            }
        }
        catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
        }
    };

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> userDTO = this.userService.findById(id);
        if(userDTO.isPresent()) {
            return ResponseEntity.ok(userDTO.get());
        } else {
            throw new NotFoundException("Not found user with " + id);
        }
    };

    @PutMapping("update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return this.userService.update(id, userDTO);
    };

    @DeleteMapping("delete/{id}")
    public void deleteUser (@PathVariable Long id) {
        this.userService.deleteById(id);
    };
}

