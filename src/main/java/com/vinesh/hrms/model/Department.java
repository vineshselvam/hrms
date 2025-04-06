package com.vinesh.hrms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "department")
    private Set<com.vinesh.hrms.model.Designation> designations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<com.vinesh.hrms.model.Employee> employees = new LinkedHashSet<>();

}