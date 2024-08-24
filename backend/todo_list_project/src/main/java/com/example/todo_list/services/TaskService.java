package com.example.todo_list.services;

import com.example.todo_list.models.Priority;
import com.example.todo_list.models.Task;
import com.example.todo_list.models.TaskDTO;
import com.example.todo_list.models.User;
import com.example.todo_list.repositories.TaskRepository;
import com.example.todo_list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;


    // create new task
    public Task addNewTask(TaskDTO taskDTO){

        //find user using userId
        User user = userRepository.findById(taskDTO.getUserId()).get();

        //create new task object using the DTO values
        Task newTask = new Task(taskDTO.getText(), taskDTO.getPriority(), taskDTO.getDueDate(), user);
        return taskRepository.save(newTask);

    }

    // get all tasks
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // get all completed tasks (and user id)
    public List<Task> getAllTasksByUserIdAndComplete(Long userId, Boolean complete){
        return taskRepository.findAllByUserIdAndComplete(userId, complete);
    }

    // get all task for a specific user
    public List<Task> getAllTaskByUserId(Long userId){
        return taskRepository.findAllByUserId(userId);
    }


    // get task by id
    public Optional<Task> getTaskById(Long taskId){
        return taskRepository.findById(taskId);
    }


    // update task text info
    public Task updateTask(Long taskId, String UpdatedTaskText){
        Task taskToUpdate = taskRepository.findById(taskId).get();
        taskToUpdate.setText(UpdatedTaskText);
        return taskRepository.save(taskToUpdate);
    }

    // update task priority
    public Task updateTaskPriority(Long taskId, Priority priority){
        Task taskToUpdate = taskRepository.findById(taskId).get();
        taskToUpdate.setPriority(priority);
        return taskRepository.save(taskToUpdate);
    }

    // update task due date
    public Task updateTaskDueDate(Long taskId, LocalDate localDate){
        Task taskToUpdate = taskRepository.findById(taskId).get();
        taskToUpdate.setDueDate(localDate);
        return taskRepository.save(taskToUpdate);
    }


    // update task to complete
    public Task updateTaskCompletion(Long taskId, Boolean complete){
        Task taskToUpdate = taskRepository.findById(taskId).get();
        taskToUpdate.setComplete(complete);
        return taskRepository.save(taskToUpdate);
    }



    // delete task

    public void deleteTask(Long taskId){
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if(taskOptional.isPresent()){
            Task task = taskOptional.get();

            // Remove the association with the user
            task.setUser(null);

            //delete task
            taskRepository.delete(task);

        }
    }


    //
}
