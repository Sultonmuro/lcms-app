package com.example.lcmsapp.repository;

import com.example.lcmsapp.entity.Course;
import com.example.lcmsapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    
}
