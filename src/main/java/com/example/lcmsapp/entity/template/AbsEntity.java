package com.example.lcmsapp.entity.template;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@MappedSuperclass
public class AbsEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    //security ishlatiladigan
    //kim qo'shdi user uuid
//    @CreatedBy
//    @Column(nullable = false, name = "created_by")
//    private UUID createdBy;
//    //kim o'zgartirdi
//    @LastModifiedBy
//    @Column(nullable = false)
//    private UUID updatedBy;

    //qachon qo'shgan
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    //qachon o'zgardi
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;
}
