package com.project.jobsphere.entity;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String email;

    private String password;  // For Basic Authentication

    private String role = "ROLE_EMPLOYER";

    // An employer can post many jobs (OneToMany with Job)
    @OneToMany(mappedBy = "employer")
    @Fetch(FetchMode.JOIN)
    private List<Job> jobs = new ArrayList<Job>();

    // Getters and setters
}
