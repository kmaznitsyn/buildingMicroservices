package com.example.departmentservice.converter;

import com.example.departmentservice.dto.DepartmentDto;
import org.springframework.stereotype.Component;
import com.example.departmentservice.entity.Department;

/**
 * Converts {@link Department} entity
 */
@Component
public class DepartmentConverter {

    public DepartmentDto convertToDto(Department department) {
        return new DepartmentDto(
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }
}
