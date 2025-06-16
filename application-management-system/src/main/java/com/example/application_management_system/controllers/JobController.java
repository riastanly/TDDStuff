package com.example.application_management_system.controllers;

import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.entity.Application;
import com.example.application_management_system.entity.Job;
import com.example.application_management_system.services.JobService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.ok(createdJob);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
//        Job job = jobService.getJobById(id);
//        return ResponseEntity.ok(job);
//    }

    @PostMapping("/add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId, @RequestParam Long jobId) {
        Applicant updatedApplicant = jobService.addJobToApplicant(applicantId, jobId);
        return ResponseEntity.ok(updatedApplicant);
    }
}
