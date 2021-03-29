package com.example.mamedova_kr.repository;

import com.example.mamedova_kr.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
