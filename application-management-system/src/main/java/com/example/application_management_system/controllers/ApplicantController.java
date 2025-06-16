package com.example.application_management_system.controllers;

import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("/getByStatus")
    public List<Applicant> getApplicantByStatus(@RequestParam String status) {
        return applicantService.getApplicantByStatusOrderByNameAsc(status);
    }

    @GetMapping("/getByName")
    public List<Applicant> getApplicantByName(@RequestParam String name) {
        return applicantService.getApplicantsByPartialName(name);
    }

    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicantCrud(applicant);
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantsUsingPagination(
            @RequestParam int page,
            @RequestParam int size) {
        return applicantService.getApplicantsUsingPagination(page, size);
    }
}
