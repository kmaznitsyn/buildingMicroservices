package com.example.employeeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends Identifier {

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;
}
