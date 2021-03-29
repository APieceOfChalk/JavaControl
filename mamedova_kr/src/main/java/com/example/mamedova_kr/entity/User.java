package com.example.mamedova_kr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User extends General{
    private String login;
    private String lastName;
    private String firstName;
    private String patronymic; // отчество
    private String dateOfBirth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
}
