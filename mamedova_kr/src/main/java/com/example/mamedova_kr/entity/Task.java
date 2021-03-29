package com.example.mamedova_kr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Task extends General{
    private String name;
    private String description;
    private String dateOfExecute; // Дата выполнения
    private Boolean completed;
    private String category;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();
}
