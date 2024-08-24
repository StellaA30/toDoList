package com.example.todo_list.services;


import com.example.todo_list.models.User;
import com.example.todo_list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // create new user
    public User addNewUser(User user){
        // save and return the saved user object
         return userRepository.save(user);
    }

    //get all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    //get user by id
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    // get user for logging in
    public User getUserForLogin(String userName, String password){
        User foundUser = userRepository.findByUserNameAndPassword(userName, password);
        return foundUser;
    }



    // update user
    public User updateUser(Long userId, User user){
        Optional<User> existingUserOptional = userRepository.findById(userId);
        if(existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();

            // update user properties that matches the constructor
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());

            // save the updated user
            return userRepository.save(existingUser);

        }else{
            // user not found
            return null;
        }
    }


    // method without optional
//    public void updateUser(User user , Long id){
//        User userToUpdate = userRepository.findById(id).get();
//        userToUpdate.setFirstName(user.getFirstName());
//        userToUpdate.setLastName(user.getLastName());
//        userToUpdate.setUserName(user.getUserName());
//        userToUpdate.setPassword(user.getPassword());

//        userRepository.save(userToUpdate);
//    }


    // delete user
    public void deleteUser(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
        }
    }


}
