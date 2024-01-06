package com.recaptcha.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.GeneratorStrategy;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
}
