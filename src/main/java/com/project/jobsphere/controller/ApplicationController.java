package com.project.jobsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.project.jobsphere.dto.ApplicationDTO;
import com.project.jobsphere.entity.Application;
import com.project.jobsphere.entity.Employee;
import com.project.jobsphere.entity.Job;
import com.project.jobsphere.mapper.ApplicationMapper;
import com.project.jobsphere.service.ApplicationService;
import com.project.jobsphere.service.EmployeeService;
import com.project.jobsphere.service.JobService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicationMapper applicationMapper;
    // Apply for a Job
    @PostMapping("/{jobId}")
    public ResponseEntity<?> applyForJob(@RequestBody Application application , @PathVariable Long jobId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getEmployeeProfile(auth.getName()).get();
        application.setEmployee(employee);

        Job job = jobService.getJobById(jobId);
        application.setJob(job);
        
        Application newApplication = applicationService.applyForJob(application);
        if (newApplication == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(406));
        }
        return ResponseEntity.ok(applicationMapper.toDTO(newApplication));
    }

    // Get Application Details
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getApplication(@PathVariable Long id) {
        Application application = applicationService.getApplicationById(id);
        if (application == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(applicationMapper.toDTO(application));
    }

    // Update Application
    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> updateApplication(@PathVariable Long id, @RequestBody Application applicationDetails) {
        Application updatedApplication = applicationService.updateApplication(id, applicationDetails);
        if (updatedApplication!= null) {
            return ResponseEntity.ok(applicationMapper.toDTO(updatedApplication));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Application
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    // Get All Applications for a Job
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsForJob(@PathVariable Long jobId) {
        List<Application> applications = applicationService.getApplicationsForJob(jobId);
        List<ApplicationDTO> applicationDTOs = new ArrayList<>();
        for(Application application : applications){
            applicationDTOs.add(applicationMapper.toDTO(application));
        }
        return ResponseEntity.ok(applicationDTOs);
    }

}

