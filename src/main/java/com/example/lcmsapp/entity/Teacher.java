package com.example.lcmsapp.entity;

import com.example.lcmsapp.entity.enums.PositionType;
import com.example.lcmsapp.entity.template.AbsEntity;

import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class Teacher  extends AbsEntity {
    private String fullname,phone;
    private Double Balance;
    private boolean active;
    @ManyToOne
    private Course course;
    @Enumerated
    private PositionType positionType = PositionType.MENTOR;

}
