package com.example.todo_list.controllers;


import com.example.todo_list.models.Priority;
import com.example.todo_list.models.Task;
import com.example.todo_list.models.TaskDTO;
import com.example.todo_list.models.User;
import com.example.todo_list.services.TaskService;
import com.example.todo_list.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "tasks")
public class TaskController {


    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;


    // post new task

    @PostMapping
    public ResponseEntity<Task> createNewTask(TaskDTO taskDTO){
        Task task = taskService.addNewTask(taskDTO);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    // get specific task
    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id){
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent()){
            return new ResponseEntity<>(task.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    // get all tasks/derived queries

    public ResponseEntity<List<Task>> getAllTask(@RequestParam(required = false, name = "user_id") Long userId,
                                                 @RequestParam(required = false, name = "complete") Boolean complete){
        // gets complete/incomplete task for specific user
        if(userId != null && complete!=null){
            return new ResponseEntity<>(taskService.getAllTasksByUserIdAndComplete(userId, complete), HttpStatus.OK);
            // gets tasks for specific user
        } else if (userId != null){
            return new ResponseEntity<>(taskService.getAllTaskByUserId(userId), HttpStatus.OK);
        }
        // get all tasks -- default request
        List<Task> allTasks = taskService.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);
    }


    // delete task

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteTaskById(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }


    // update task
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,
                                           @RequestBody(required = false) String text,
                                           @RequestParam(required = false)Priority priority,
                                           @RequestParam(required = false, name = "due_date")LocalDate dueDate,
                                           @RequestParam(required = false) Boolean complete){
        // update task priority
        if(priority != null){
            return new ResponseEntity<>(taskService.updateTaskPriority(id, priority), HttpStatus.OK);
        }

        // update task due date
        if(dueDate != null){
            return new ResponseEntity<>(taskService.updateTaskDueDate(id, dueDate), HttpStatus.OK);
        }

        // update completion status
        if(complete != null){
            return new ResponseEntity<>(taskService.updateTaskCompletion(id, complete), HttpStatus.OK);
        }

        // update text
        return new ResponseEntity<>(taskService.updateTask(id, text), HttpStatus.OK);

    }
}
