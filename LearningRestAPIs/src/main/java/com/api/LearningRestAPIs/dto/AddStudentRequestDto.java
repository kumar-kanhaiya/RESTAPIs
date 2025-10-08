package com.api.LearningRestAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDto {
    @NotNull(message = "Name should not blank")
    private String name;

    @Email
    @NotNull(message = "email should not blank")
    private String email;
}
