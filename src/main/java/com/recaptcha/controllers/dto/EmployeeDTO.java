package com.recaptcha.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
