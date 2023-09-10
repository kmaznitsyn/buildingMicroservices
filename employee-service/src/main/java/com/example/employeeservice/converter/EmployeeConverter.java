package com.example.employeeservice.converter;

import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public Employee convertToEmployee(EmployeeDto dto) {
        return new Employee(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail()
        );
    }
}
