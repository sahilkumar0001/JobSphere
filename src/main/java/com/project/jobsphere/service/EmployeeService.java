package com.project.jobsphere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.jobsphere.entity.Employee;
import com.project.jobsphere.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Employee registerEmployee(Employee employee) {
        // Set the default role for an Employee
        employee.setRole("ROLE_EMPLOYEE");
        // Encrypt the password before saving
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeProfile(String email) {
        return employeeRepository.findByEmail(email);
    }

     // Update an existing employee
     public Employee updateEmployee(String email, Employee employeeDetails) {
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(email);
        existingEmployee.get().setName(employeeDetails.getName());
        if (employeeDetails.getPassword() !=null) {
            existingEmployee.get().setPassword(passwordEncoder.encode(employeeDetails.getPassword()));
        }
        // Update other fields as necessary
        return employeeRepository.save(existingEmployee.get());
    }

    // Delete an employee
    public void deleteEmployee(String email) {
        Employee employee = employeeRepository.findByEmail(email).get();
        employeeRepository.deleteById(employee.getId());
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

