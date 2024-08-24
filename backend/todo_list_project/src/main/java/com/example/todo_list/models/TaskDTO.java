package com.example.todo_list.models;


import java.time.LocalDate;

public class TaskDTO {

    private String text;
    private Priority priority;
    private LocalDate dueDate;
    private boolean complete;
    private Long userId;

    public TaskDTO(String text, Priority priority, LocalDate dueDate, Long userId){
        this.text = text;
        this.priority = priority;
        this.dueDate = dueDate;
        this.userId = userId;
    }



//    default constructor
    public TaskDTO(){}


    // getters and setters


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
