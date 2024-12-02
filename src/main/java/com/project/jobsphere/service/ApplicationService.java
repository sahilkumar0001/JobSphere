package com.project.jobsphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jobsphere.entity.Application;
import com.project.jobsphere.repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // Apply for a job
    public Application applyForJob(Application application) {
        if(applicationRepository.existsByJobAndEmployee(application.getJob(),application.getEmployee())){
            return null;
        }
        application.setStatus("Applied");
        return applicationRepository.save(application);
    }

    // Retrieve an application by ID
    public Application getApplicationById(Long id){
        Optional<Application> application =  applicationRepository.findById(id);
        return application.orElse(null);
    }

    // Update an application
    public Application updateApplication(Long id, Application applicationDetails) {
        Application existingApplication = applicationRepository.findById(id).get();
        if (existingApplication==null) {
            return null;
        }
        if(applicationDetails.getResume() != null){
            existingApplication.setResume(applicationDetails.getResume());
        }
        existingApplication.setStatus(applicationDetails.getStatus());
        // Update other fields as necessary
        return applicationRepository.save(existingApplication);
    }

    // Delete an application
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    // Get all applications for a job
    public List<Application> getApplicationsForJob(Long jobId) {
        return applicationRepository.findByJob_Id(jobId);
    }

    // Get all applications for an employee
    public List<Application> getApplicationsForEmployee(Long employeeId) {
        return applicationRepository.findByEmployee_Id(employeeId);
    }
}

