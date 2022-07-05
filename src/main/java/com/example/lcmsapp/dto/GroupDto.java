package com.example.lcmsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GroupDto {
    @NotNull(message = " Id null bolishi mumkin emas! ")
    private Long id;
    @NotNull(message = "name cannot be null!")
    private String name;
    private Long courseId;
    private Long filialId;

}
