package com.example.application_management_system.services;

import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.entity.Resume;
import com.example.application_management_system.repositories.ApplicantJpaRepo;
import com.example.application_management_system.repositories.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {
    @Autowired
    ApplicantJpaRepo applicantJpaRepo;
    @Autowired
    ResumeRepo resumeRepo;

    public Resume addResume(Long applicantId, Resume resume) {
        Optional<Applicant> applicantOptional = applicantJpaRepo.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);
            return resumeRepo.save(resume);
        } else {
            throw new RuntimeException("Applicant not found with id " + applicantId);
        }
    }
}
