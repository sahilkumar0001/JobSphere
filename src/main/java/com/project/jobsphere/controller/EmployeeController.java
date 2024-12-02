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

import com.project.jobsphere.dto.ApplicationDTO;
import com.project.jobsphere.dto.EmployeeDTO;

import com.project.jobsphere.entity.Application;
import com.project.jobsphere.entity.Employee;
import com.project.jobsphere.mapper.ApplicationMapper;
import com.project.jobsphere.mapper.EmployeeMapper;
import com.project.jobsphere.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ApplicationMapper applicationMapper;
    
    @PostMapping("/register")
    public ResponseEntity<EmployeeDTO> registerEmployee(@RequestBody Employee employee) {
        Employee registeredEmployee = employeeService.registerEmployee(employee);
        return ResponseEntity.ok(employeeMapper.toDto(registeredEmployee));
    }

    // Get Employee Profile
    @GetMapping("/")
    public ResponseEntity<EmployeeDTO> getProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee employee = employeeService.getEmployeeProfile(auth.getName()).get();
        return ResponseEntity.ok(employeeMapper.toDto(employee));

    }

    // Update Employee Profile
    @PutMapping("/")
    public ResponseEntity<EmployeeDTO> updateProfile(@RequestBody Employee employeeDetails) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee updatedEmployee = employeeService.updateEmployee(auth.getName(), employeeDetails);
        return ResponseEntity.ok(employeeMapper.toDto(updatedEmployee));
    }

    // Delete Employee Account
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAccount() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        employeeService.deleteEmployee(auth.getName());
        return ResponseEntity.noContent().build();
    }

    // Get All Employees (Admin Access)
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
     List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
    for (Employee employee : employees) {
        employeeDTOs.add(employeeMapper.toDto(employee));
    }
     return ResponseEntity.ok(employeeDTOs);
    }

    //Get All Employee Applications
    @GetMapping("/applications")
    public ResponseEntity<List<ApplicationDTO>> getEmployeeApplication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    Employee employee = employeeService.getEmployeeProfile(auth.getName()).get();
    List<Application> applications = employee.getApplications();
    List<ApplicationDTO> applicationDTOs = new ArrayList<ApplicationDTO>();
    for (Application application : applications) {
        applicationDTOs.add(applicationMapper.toDTO(application));
    }
    return ResponseEntity.ok(applicationDTOs);
    }
}
