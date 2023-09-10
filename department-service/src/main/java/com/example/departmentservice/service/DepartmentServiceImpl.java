package com.example.departmentservice.service;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.exception.DepartmentCodeAlreadyExistsException;
import com.example.departmentservice.exception.ResourceNotFoundException;
import com.example.departmentservice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto dto) {
        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentCode(dto.getDepartmentCode());
        if (optionalDepartment.isPresent()) {
            throw new DepartmentCodeAlreadyExistsException("Department with code '" + dto.getDepartmentCode() + "' already exists");
        }
        Department department = modelMapper.map(dto, Department.class);
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department", "departmentCode", departmentCode)
        );
        return modelMapper.map(department, DepartmentDto.class);
    }
}
