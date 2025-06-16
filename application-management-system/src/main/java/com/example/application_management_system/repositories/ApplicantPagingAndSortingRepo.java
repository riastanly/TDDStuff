package com.example.application_management_system.repositories;

import com.example.application_management_system.entity.Applicant;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantPagingAndSortingRepo extends PagingAndSortingRepository<Applicant, Long> , ListCrudRepository<Applicant, Long> {
}
