package com.example.mamedova_kr.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category extends General{
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Task> task = new ArrayList<>();
}
