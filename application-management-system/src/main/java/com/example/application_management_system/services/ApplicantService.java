package com.example.application_management_system.services;

import com.example.application_management_system.entity.Applicant;
import com.example.application_management_system.entity.Application;
import com.example.application_management_system.entity.Resume;
import com.example.application_management_system.repositories.ApplicantCrudRepo;
import com.example.application_management_system.repositories.ApplicantJpaRepo;
import com.example.application_management_system.repositories.ApplicantPagingAndSortingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantCrudRepo applicantCrudRepo;

    @Autowired
    private ApplicantPagingAndSortingRepo applicantPagingAndSortingRepo;

    @Autowired
    private ApplicantJpaRepo applicantJpaRepo;

    public List<Applicant> getAllApplicants() {
//        Iterable<Applicant> allApplicants = applicantCrudRepo.findAll();
//        List<Applicant> applicantList = new ArrayList<>();
//        allApplicants.forEach(applicantList::add);
        List<Applicant> applicantList = applicantCrudRepo.findAll();
        return applicantList;
    }

    public List<Applicant> getApplicantByStatusOrderByNameAsc(String status) {
        return applicantJpaRepo.findByStatusOrderByNameAsc(status);
    }

    public List<Applicant> getApplicantsByPartialName(String name) {
        return applicantJpaRepo.findApplicantsByPartialName(name);
    }


    public Applicant saveApplicantCrud(Applicant applicant) {
        Resume resume = applicant.getResume();
        List<Application> applications = applicant.getApplications();
        if (resume != null) {
            resume.setApplicant(applicant);
        }

        if (applications != null) {
            for (Application application: applications) {
                application.setApplicant(applicant);
            }
        }
        return applicantCrudRepo.save(applicant);
    }

    public Iterable<Applicant> getApplicantsUsingPagination(int page, int size) {
        return applicantPagingAndSortingRepo.findAll(PageRequest.of(page, size));
    }


}
