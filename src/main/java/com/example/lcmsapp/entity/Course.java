package com.example.lcmsapp.entity;

import com.example.lcmsapp.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "course")

@Getter
@Setter
@ToString
public class Course extends AbsNameEntity {
    private Double price;

    //studentList

}
