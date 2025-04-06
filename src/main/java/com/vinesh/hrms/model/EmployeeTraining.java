package com.vinesh.hrms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_training")
public class EmployeeTraining {
    @EmbeddedId
    private EmployeeTrainingId id;

    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private com.vinesh.hrms.model.Employee employee;

    @MapsId("trainingId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "training_id", nullable = false)
    private com.vinesh.hrms.model.TrainingSession training;

}