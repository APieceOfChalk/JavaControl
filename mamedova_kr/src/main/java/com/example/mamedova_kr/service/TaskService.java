package com.example.mamedova_kr.service;

import com.example.mamedova_kr.entity.Task;
import com.example.mamedova_kr.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void create(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task find(Long id){
        return taskRepository.getOne(id);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
