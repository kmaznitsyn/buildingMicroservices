package com.example.departmentservice.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Base Entity that contains id attribute
 */
@Getter
@Setter
@MappedSuperclass
public class Identifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
