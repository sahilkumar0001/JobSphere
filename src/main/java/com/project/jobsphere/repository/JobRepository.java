package com.project.jobsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jobsphere.entity.Job;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
