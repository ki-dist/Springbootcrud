package com.example.trainingproject.Controller;

import com.example.trainingproject.Service.AccountService;
import com.example.trainingproject.Service.UserService;
import com.example.trainingproject.model.Account;
import com.example.trainingproject.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/addUser")

    public ResponseEntity<?> Save(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

    }
    @GetMapping("/users")


    public ResponseEntity<List<User>> findAllUser(){
        List<User> accountList =userService.getUsers();

        return new ResponseEntity<>(accountList, HttpStatus.OK);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user){
        userService. updateUser(user);
        return new ResponseEntity<>(userService.getById(user.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
