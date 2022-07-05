package com.example.lcmsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    private T data;
    private String message;
    private boolean success;

    public ApiResponse() {
    }

    public ApiResponse(String message,boolean success) {
        this.message = message;
        this.success = success;
    }
}
