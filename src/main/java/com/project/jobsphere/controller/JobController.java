package com.project.jobsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.project.jobsphere.dto.JobDTO;
import com.project.jobsphere.entity.Employer;
import com.project.jobsphere.entity.Job;
import com.project.jobsphere.mapper.JobMapper;
import com.project.jobsphere.service.EmployerService;
import com.project.jobsphere.service.JobService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private JobMapper jobMapper;
    // Create Job Posting
    @PostMapping("/")
    public ResponseEntity<JobDTO> createJob(@RequestBody Job job) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employer employer = employerService.getEmployerProfile(auth.getName()).get();
        job.setEmployer(employer);
        JobDTO newJob = jobMapper.toDto(jobService.createJob(job));

        return ResponseEntity.ok(newJob);
    }

    // Get Job Details
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jobMapper.toDto(job));
    }

    // Update Job Posting
    @PutMapping("/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long id, @RequestBody Job jobDetails) {
        Job updatedJob = jobService.updateJob(id, jobDetails);
        if (updatedJob!=null) {
            return ResponseEntity.ok(jobMapper.toDto(updatedJob));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Job Posting
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>("Deleted ",HttpStatus.NO_CONTENT);
    }

    // Get All Jobs
    @GetMapping("/all")
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        List<JobDTO> jobDTOs = new ArrayList<>();
        for(Job job : jobs){
            jobDTOs.add(jobMapper.toDto(job));
        };
        return ResponseEntity.ok(jobDTOs);
    }
}
