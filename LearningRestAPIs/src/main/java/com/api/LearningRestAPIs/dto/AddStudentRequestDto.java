package com.api.LearningRestAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AddStudentRequestDto {
    @NotNull(message = "Name should not blank")
    private String name;

    @Email
    @NotNull(message = "email should not blank")
    private String email;
}
