package com.example.todo_list.components;


import com.example.todo_list.models.User;
import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{


        //Users

        User user1 = new User("Stella", "Annor", "Star01", "1234");
        userRepository.save(user1);

        User user2 = new User("Florian", "Annor", "Nigro12", "ILoveStella4ever");
        userRepository.save(user2);


        //Tasks












    }
}
