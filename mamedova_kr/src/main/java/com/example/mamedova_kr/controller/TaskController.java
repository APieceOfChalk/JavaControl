package com.example.mamedova_kr.controller;

import com.example.mamedova_kr.entity.Task;
import com.example.mamedova_kr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    public ResponseEntity<?> create(@RequestBody Task task) {
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/tasks")
    public ResponseEntity<List<Task>> findAll() {
        final List<Task> taskList = taskService.findAll();

        return taskList != null && !taskList.isEmpty()
                ? new ResponseEntity<>(taskList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/tasks/{id}")
    public ResponseEntity<Task> find(@PathVariable(name="id") Long id) {
        final Task task = taskService.find(id);

        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/tasks/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id) {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/tasks/{id}")
    public ResponseEntity<?> put(@RequestBody Task task) {
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
