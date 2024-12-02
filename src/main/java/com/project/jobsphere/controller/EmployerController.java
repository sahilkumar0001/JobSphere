package com.project.jobsphere.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jobsphere.dto.EmployerDTO;
import com.project.jobsphere.dto.JobDTO;
import com.project.jobsphere.entity.Employer;
import com.project.jobsphere.entity.Job;
import com.project.jobsphere.mapper.EmployerMapper;
import com.project.jobsphere.mapper.JobMapper;
import com.project.jobsphere.service.EmployerService;


@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private EmployerMapper employerMapper;

    @PostMapping("/register")
    public ResponseEntity<EmployerDTO> registerEmployer(@RequestBody Employer employer) {
        Employer registeredEmployer = employerService.registerEmployer(employer);
        return ResponseEntity.ok(employerMapper.toDto(registeredEmployer));
    }

    @GetMapping("/")
    public ResponseEntity<EmployerDTO> getEmployerProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employer employer = employerService.getEmployerProfile(auth.getName()).get();
        return ResponseEntity.ok(employerMapper.toDto(employer));
    }

     // Update Employer Profile
 @PutMapping("/")
 public ResponseEntity<EmployerDTO> updateProfile( @RequestBody Employer EmployerDetails) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     Employer updatedEmployer = employerService.updateEmployer(auth.getName(), EmployerDetails);
     return ResponseEntity.ok(employerMapper.toDto(updatedEmployer));
 }

 // Delete Employer Account
 @DeleteMapping("/")
 public ResponseEntity<Void> deleteAccount() {
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     employerService.deleteEmployer(auth.getName());
     return ResponseEntity.noContent().build();
 }

 // Get All Employers (Admin Access)
 @GetMapping("/all")
 public ResponseEntity<List<EmployerDTO>> getAllEmployers() {
     List<Employer> employers = employerService.getAllEmployers();
     List<EmployerDTO> employerDTOs = new ArrayList<EmployerDTO>();
    for (Employer employer : employers) {
        employerDTOs.add(employerMapper.toDto(employer));
    }
     return ResponseEntity.ok(employerDTOs);
 }

 @GetMapping("/jobs")
 public List<JobDTO> getEmployerJobs() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Employer employer = employerService.getEmployerProfile(auth.getName()).get();
    List<Job> jobs = employer.getJobs();
    List<JobDTO> jobDTOs = new ArrayList<JobDTO>();
    for (Job job : jobs) {
        jobDTOs.add(jobMapper.toDto(job));
    }
    return jobDTOs;
 }

}
