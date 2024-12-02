package com.project.jobsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jobsphere.entity.Application;
import com.project.jobsphere.entity.Employee;
import com.project.jobsphere.entity.Job;

import java.util.List;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public List<Application> findByJob_Id(long id);
    public boolean existsByJobAndEmployee(Job job, Employee employee);
    public List<Application> findByEmployee_Id(Long employeeId);
}
