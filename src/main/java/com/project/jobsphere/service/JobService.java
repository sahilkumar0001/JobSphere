package com.project.jobsphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jobsphere.entity.Job;
import com.project.jobsphere.repository.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Create a new job posting
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // Retrieve a job by ID
    public Job getJobById(Long id) {
        Optional<Job> job =  jobRepository.findById(id);
        return job.orElse(null);
    }

    // Update an existing job
    public Job updateJob(Long id, Job jobDetails) {
        Job existingJob = jobRepository.findById(id).orElse(null);
        if (existingJob ==null) {
            return null;
        }
        existingJob.setTitle(jobDetails.getTitle());
        existingJob.setDescription(jobDetails.getDescription());
        existingJob.setSalary(jobDetails.getSalary());
        // Update other fields as necessary
        return jobRepository.save(existingJob);
    }

    // Delete a job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
}
