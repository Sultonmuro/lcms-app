package com.example.lcmsapp.entity;

import com.example.lcmsapp.entity.enums.StudentStatus;
import com.example.lcmsapp.entity.template.AbsEntity;
import com.example.lcmsapp.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
@Getter
@Setter
@ToString

public class Student extends AbsEntity {
    private String fullName, phone;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @ManyToMany
    private List<Group> groups;
}
