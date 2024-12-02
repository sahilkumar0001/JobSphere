package com.project.jobsphere.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.jobsphere.entity.Employee;
import com.project.jobsphere.entity.Employer;
import com.project.jobsphere.repository.EmployeeRepository;
import com.project.jobsphere.repository.EmployerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Check if the email belongs to an Employee
        Optional<Employee> employee = employeeRepository.findByEmail(email);
        if (employee.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    employee.get().getEmail(),
                    employee.get().getPassword(),
                    AuthorityUtils.createAuthorityList(employee.get().getRole())
            );
        }

        // Check if the email belongs to an Employer
        Optional<Employer> employer = employerRepository.findByEmail(email);
        if (employer.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    employer.get().getEmail(),
                    employer.get().getPassword(),
                    AuthorityUtils.createAuthorityList(employer.get().getRole())
            );
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
