package com.example.todo_list.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column
    private boolean complete;

    @ManyToOne
    // can add the nullable=false to ensure every task must be associated to a non-null user
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties({"tasks"})
    private User user;


    public Task(String text, Priority priority, LocalDate dueDate, User user){
        this.text = text;
        this.priority = priority;
        this.dueDate = dueDate;
        this.complete = false;
        this.user = user;
    }

    // default constructor
    public Task(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
