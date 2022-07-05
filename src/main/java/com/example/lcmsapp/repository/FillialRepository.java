package com.example.lcmsapp.repository;

import com.example.lcmsapp.entity.Course;
import com.example.lcmsapp.entity.Fillial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FillialRepository extends JpaRepository<Fillial,Long> {
    
}
