package com.project.jobsphere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.jobsphere.entity.Employer;
import com.project.jobsphere.repository.EmployerRepository;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //register a new employer
    public Employer registerEmployer(Employer employer) {
        // Set the default role for an Employer
        employer.setRole("ROLE_EMPLOYER");
        // Encrypt the password before saving
        employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        return employerRepository.save(employer);
    }

    //get employer profile
    public Optional<Employer> getEmployerProfile(String email) {
        return employerRepository.findByEmail(email);
    }

     // Update an existing employer
     public Employer updateEmployer(String email, Employer employerDetails) {
        Employer existingEmployer = employerRepository.findByEmail(email).get();
        existingEmployer.setCompanyName(employerDetails.getCompanyName());
        if (employerDetails.getPassword() != null) {
            existingEmployer.setPassword(passwordEncoder.encode(employerDetails.getPassword()));
        }
        // Update other fields as necessary
        return employerRepository.save(existingEmployer);
    }

    // Delete an employer
    public void deleteEmployer(String email) {
        employerRepository.deleteById(employerRepository.findByEmail(email).get().getId());
    }

    // Get all employers
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }
}
