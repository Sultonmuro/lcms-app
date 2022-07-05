package com.example.lcmsapp.repository;

import com.example.lcmsapp.entity.Course;
import com.example.lcmsapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    
}
