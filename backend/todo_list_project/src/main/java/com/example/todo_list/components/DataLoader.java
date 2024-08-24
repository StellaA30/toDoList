package com.example.todo_list.components;


import com.example.todo_list.models.Priority;
import com.example.todo_list.models.Task;
import com.example.todo_list.models.User;
import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{


        //Users

        User user1 = new User("Stella", "Annor", "Star01", "Burger1234");
        userRepository.save(user1);

        User user2 = new User("Florian", "Annor", "Hello123", "ApplePie4ever");
        userRepository.save(user2);


        //Tasks
        // Tasks for User1
        Task task1 = new Task("Buy groceries", Priority.HIGH, LocalDate.of(2024, 8, 30), user1);
        Task task2 = new Task("Complete project report", Priority.MEDIUM, LocalDate.of(2024, 11, 5), user1);

        taskRepository.save(task1);
        taskRepository.save(task2);

        // Tasks for User2
        Task task3 = new Task("Book flight tickets", Priority.LOW, LocalDate.of(2024, 9, 10), user2);
        Task task4 = new Task("Plan birthday party", Priority.HIGH, LocalDate.of(2024, 9, 15), user2);

        taskRepository.save(task3);
        taskRepository.save(task4);














    }
}
