package com.example.lcmsapp.repository;

import com.example.lcmsapp.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {
    List<Group> findGroupByFilial_NameContainingIgnoreCase(String name);
boolean existsByNameAndFilial_IdAndCourse_Id(String name, Long filialId, Long courseId);
}
