package com.example.todo_list.repositories;

import com.example.todo_list.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserIdAndComplete(Long userId, Boolean complete);

    List<Task> findAllByUserId(Long userId);

}
