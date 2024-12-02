package com.project.jobsphere.mapper;

import org.springframework.stereotype.Component;

import com.project.jobsphere.dto.EmployeeDTO;
import com.project.jobsphere.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDto(Employee employee){
        EmployeeDTO employeeDTO= new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setName(employee.getName());
        employeeDTO.setRole(employee.getRole());
        return employeeDTO;
    }

    public Employee toEntity(EmployeeDTO employeeDTO){
        Employee   employee  = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setEmail(employeeDTO.getEmail());
        employee.setName(employeeDTO.getName());
        return employee;
    }
}
