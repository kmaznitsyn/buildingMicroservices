package com.example.departmentservice.service;

import com.example.departmentservice.converter.DepartmentConverter;
import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentConverter departmentConverter;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto dto) {
        Department department = new Department(
                dto.getDepartmentName(),
                dto.getDepartmentDescription(),
                dto.getDepartmentCode()
        );
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        if (department == null) {
            throw new RuntimeException("Department was not found by code " + departmentCode);
        }
        return departmentConverter.convertToDto(department);
    }
}
