package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
public class Post {
    @Id
    Long id;

    String title;

    @Column(columnDefinition = "TEXT")
    String body;
}
