package com.example.lcmsapp.repository;

import com.example.lcmsapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Course,Long> {
    
}
