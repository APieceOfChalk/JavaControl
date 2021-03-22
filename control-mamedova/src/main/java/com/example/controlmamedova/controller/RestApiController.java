package com.example.controlmamedova.controller;


import com.example.controlmamedova.entity.News;
import com.example.controlmamedova.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class RestApiController {

    private final NewsService NewsService;

    @Autowired
    public RestApiController(NewsService NewsService){
        this.NewsService = NewsService;
    }

    public ResponseEntity<?> create(@RequestBody News news) {
        NewsService.create(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/news")
    public ResponseEntity<List<News>> findAll() {
        final List<News> newsList = NewsService.findAll();

        return newsList != null && !newsList.isEmpty()
                ? new ResponseEntity<>(newsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/news/{id}")
    public ResponseEntity<News> find(@PathVariable(name="id") Long id) {
        final News news = NewsService.find(id);

        return news != null
                ? new ResponseEntity<>(news, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/news/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id) {
        NewsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/news/{id}")
    public ResponseEntity<?> put(@RequestBody News news) {
        NewsService.create(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
