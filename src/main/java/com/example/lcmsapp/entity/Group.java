package com.example.lcmsapp.entity;

import com.example.lcmsapp.entity.Course;
import com.example.lcmsapp.entity.Fillial;
import com.example.lcmsapp.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups")
@Setter
@Getter
@ToString

public class Group extends AbsNameEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Course course;

    @ManyToOne
    private Fillial filial;
}