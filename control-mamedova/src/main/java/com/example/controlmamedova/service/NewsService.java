package com.example.controlmamedova.service;

import com.example.controlmamedova.entity.News;
import com.example.controlmamedova.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository NewsRepository;

    public void create(News news){
        NewsRepository.save(news);
    }

    public List<News> findAll(){
        return NewsRepository.findAll();
    }

    public News find(Long id){
        return NewsRepository.getOne(id);
    }

    public void delete(Long id) {NewsRepository.deleteById(id);}



}
