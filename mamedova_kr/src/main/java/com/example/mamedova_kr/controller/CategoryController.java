package com.example.mamedova_kr.controller;

import com.example.mamedova_kr.entity.Category;
import com.example.mamedova_kr.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public ResponseEntity<?> create(@RequestBody Category category) {
        categoryService.create(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/categories")
    public ResponseEntity<List<Category>> findAll() {
        final List<Category> categoryList = categoryService.findAll();

        return categoryList != null && !categoryList.isEmpty()
                ? new ResponseEntity<>(categoryList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/categories/{id}")
    public ResponseEntity<Category> find(@PathVariable(name="id") Long id) {
        final Category category = categoryService.find(id);

        return category != null
                ? new ResponseEntity<>(category, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/categories/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/categories/{id}")
    public ResponseEntity<?> put(@RequestBody Category category) {
        categoryService.create(category);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
