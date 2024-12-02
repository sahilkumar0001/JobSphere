package com.project.jobsphere.mapper;

import org.springframework.stereotype.Component;

import com.project.jobsphere.dto.EmployerDTO;
import com.project.jobsphere.entity.Employer;

@Component
public class EmployerMapper {

    public EmployerDTO toDto(Employer employer){
        EmployerDTO employerDTO = new EmployerDTO();
        employerDTO.setId(employer.getId());
        employerDTO.setEmail(employer.getEmail());
        employerDTO.setCompanyName(employer.getCompanyName());
        employerDTO.setRole(employer.getRole());
        return employerDTO;
    }
    public Employer toEntity(EmployerDTO employerDTO){
        Employer employer = new Employer();
        employer.setId(employerDTO.getId());
        employer.setEmail(employerDTO.getEmail());
        employer.setCompanyName(employerDTO.getCompanyName());
        return employer;
    }
}
