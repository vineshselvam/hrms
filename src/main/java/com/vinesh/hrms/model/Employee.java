package com.vinesh.hrms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private com.vinesh.hrms.model.User user;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "phone", length = 15)
    private String phone;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @OneToMany(mappedBy = "employee")
    private Set<Attendance> attendances = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<Document> documents = new LinkedHashSet<>();

    @ManyToMany
    private Set<com.vinesh.hrms.model.TrainingSession> trainingSessions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<com.vinesh.hrms.model.LeaveRequest> leaveRequests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee")
    private Set<com.vinesh.hrms.model.Payroll> payrolls = new LinkedHashSet<>();

    @OneToMany(mappedBy = "reviewer")
    private Set<com.vinesh.hrms.model.PerformanceReview> performanceReviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "assignedTo")
    private Set<com.vinesh.hrms.model.Task> tasks = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address1;

}