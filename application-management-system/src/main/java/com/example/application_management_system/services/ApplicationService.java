package com.example.application_management_system.services;

import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.entity.Application;
import com.example.application_management_system.repositories.ApplicantJpaRepo;
import com.example.application_management_system.repositories.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicantJpaRepo applicantJpaRepo;
    @Autowired
    private ApplicationRepo applicationRepo;

    public Application saveApplication(Long applicantId,Application application) {
        Optional<Applicant> applicantOptional = applicantJpaRepo.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            application.setApplicant(applicant);
            return applicationRepo.save(application);
        } else {
            throw new RuntimeException("Applicant not found with id" + applicantId);
        }
    }
}
