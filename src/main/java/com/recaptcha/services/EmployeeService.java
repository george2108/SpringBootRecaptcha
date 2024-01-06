package com.recaptcha.services;

import com.recaptcha.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> findAll();

    EmployeeEntity findById(Long id);

    EmployeeEntity save(EmployeeEntity employeeEntity);

    void deleteById(Long id);
}
