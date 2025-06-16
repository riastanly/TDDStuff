package com.example.application_management_system.repositories;

import com.example.application_management_system.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Long> {
}
