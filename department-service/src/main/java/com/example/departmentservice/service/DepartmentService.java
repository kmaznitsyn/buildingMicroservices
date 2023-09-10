package com.example.departmentservice.service;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto dto);

    DepartmentDto getDepartmentByCode(String code);
}
