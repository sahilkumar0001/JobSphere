package com.project.jobsphere.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;  // For Basic Authentication

    private String role = "ROLE_EMPLOYEE";

    // An employee can apply to many jobs (OneToMany with Application)
    @OneToMany(mappedBy = "employee")
    @Fetch(FetchMode.JOIN)
    private List<Application> applications = new ArrayList<Application>();

    // Getters and setters
}

