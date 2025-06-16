package com.example.application_management_system.services;

import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.entity.Job;
import com.example.application_management_system.repositories.ApplicantJpaRepo;
import com.example.application_management_system.repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private ApplicantJpaRepo applicantJpaRepo;

    @Autowired
    private JobRepo jobRepo;

    public Job createJob(Job job) {
        return jobRepo.save(job);
    }
    
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepo.findById(id);
    }

    public Applicant addJobToApplicant(Long id, Long jobId) {
        Optional<Applicant> applicant = applicantJpaRepo.findById(id);
        Optional<Job> job = jobRepo.findById(jobId);

        if(applicant.isPresent() && job.isPresent()) {
            applicant.get().getJobs().add(job.get());
            applicantJpaRepo.save(applicant.get());
            return applicant.get();
        } else {
            throw new IllegalArgumentException("Appln or job not found");
        }
    }
}
