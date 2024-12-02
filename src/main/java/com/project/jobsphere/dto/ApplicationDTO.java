package com.project.jobsphere.dto;


import lombok.Data;

@Data
public class ApplicationDTO {
    private Long id;
    private String resume;
    private String status;
    private EmployeeDTO employeeDTO;
    private JobDTO jobDTO;
}
