package com.example.application_management_system.repositories;

import com.example.application_management_system.entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

//public interface ApplicantCrudRepo extends CrudRepository<Applicant, Long> {
//}

@Repository
public interface ApplicantCrudRepo extends ListCrudRepository<Applicant, Long> {
}
