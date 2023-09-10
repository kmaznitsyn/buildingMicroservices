package com.example.employeeservice.service;

import com.example.employeeservice.converter.EmployeeConverter;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeConverter employeeConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeConverter.convertToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        log.info("Employee saved successfully");
        return employeeConverter.convertToDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException("Employee does not exist with id " + id);
        }
        return employeeConverter.convertToDto(optionalEmployee.get());
    }
}
