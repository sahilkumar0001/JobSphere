package com.project.jobsphere.mapper;

import org.springframework.stereotype.Component;

import com.project.jobsphere.dto.JobDTO;
import com.project.jobsphere.entity.Employer;
import com.project.jobsphere.entity.Job;

@Component
public class JobMapper {
    public JobDTO toDto(Job job){
        JobDTO jobDto = new JobDTO();
        jobDto.setId(job.getId());
        jobDto.setTitle(job.getTitle());
        jobDto.setDescription(job.getDescription());
        jobDto.setLocation(job.getLocation());
        jobDto.setSalary(job.getSalary());
        jobDto.setEmployerName(job.getEmployer().getCompanyName());
        jobDto.setApplications(job.getApplications().size());
        return jobDto;
    }

    public Job toEntity(JobDTO jobDto, Employer employer){
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        job.setLocation(jobDto.getLocation());
        job.setSalary(jobDto.getSalary());
        job.setEmployer(employer);
        return job;
    }
}
