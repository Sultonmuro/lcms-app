package com.example.lcmsapp.entity;

import com.example.lcmsapp.entity.enums.ExpenseType;
import com.example.lcmsapp.entity.enums.PayType;
import com.example.lcmsapp.entity.template.AbsEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Expense  extends AbsEntity {
    private String description;
    @Enumerated
    private ExpenseType expenseType;
    @ManyToOne
    private Fillial filial;
    private Double amount;

    @Enumerated
    private PayType payType;
}
