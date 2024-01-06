package com.recaptcha.services.impl;

import com.recaptcha.entities.EmployeeEntity;
import com.recaptcha.persistence.EmployeeRepository;
import com.recaptcha.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity findById(Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
