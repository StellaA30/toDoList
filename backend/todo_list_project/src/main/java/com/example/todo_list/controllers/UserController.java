package com.example.todo_list.controllers;

import com.example.todo_list.models.User;
import com.example.todo_list.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        User newUser = userService.addNewUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable Long id,
                                               @RequestBody User user){
        User userToUpdate = userService.updateUser(id, user);
        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/login")
    public ResponseEntity<User> loginUser( @RequestParam(name="userName") String userName,
                                           @RequestParam(name = "password") String password){
        User userToLogin = userService.getUserForLogin(userName, password);
        if (userToLogin != null) {
            return new ResponseEntity<>(userToLogin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }


//    // COMBINES  @GetMapping(value = "/{id}") and @GetMapping(value = "/login"), doesn't quite work as it requires id
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<User> getUser(@PathVariable Long id,
//                                        @RequestParam(required = false, name="userName") String userName,
//                                        @RequestParam(required = false, name = "password") String password){
//        if(userName != null && password != null){
//            User user = userService.getUserForLogin(userName, password);
//        }else{
//            Optional<User> user = userService.getUser(id);
//            if(user.isPresent()) {
//                return new ResponseEntity<>(user.get(), HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//
//    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("You've successfully deleted user" + "user ID " + id, HttpStatus.NO_CONTENT);
    }


}
