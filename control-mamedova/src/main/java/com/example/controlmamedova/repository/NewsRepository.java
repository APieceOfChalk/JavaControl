package com.example.controlmamedova.repository;


import com.example.controlmamedova.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
