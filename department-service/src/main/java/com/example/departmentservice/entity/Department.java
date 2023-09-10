package com.example.departmentservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Department Entity
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department extends Identifier {

    private String departmentName;
    private String departmentDescription;
    @Column(unique = true, nullable = false)
    private String departmentCode;

}
