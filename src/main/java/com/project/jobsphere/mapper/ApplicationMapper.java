package com.project.jobsphere.mapper;

import org.springframework.stereotype.Component;

import com.project.jobsphere.dto.ApplicationDTO;
import com.project.jobsphere.entity.Application;

@Component
public class ApplicationMapper {
    public ApplicationDTO toDTO(Application application){
        JobMapper jobMapper = new JobMapper();
        EmployeeMapper mapper = new EmployeeMapper();
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setId(application.getId());
        applicationDTO.setResume(application.getResume());
        applicationDTO.setEmployeeDTO(mapper.toDto(application.getEmployee()));
        applicationDTO.setStatus(application.getStatus());
        applicationDTO.setJobDTO(jobMapper.toDto(application.getJob()));
        return applicationDTO;
    }
}
