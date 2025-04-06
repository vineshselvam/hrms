package com.vinesh.hrms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class EmployeeTrainingId implements Serializable {
    private static final long serialVersionUID = 3753808463510416204L;
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "training_id", nullable = false)
    private Long trainingId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeTrainingId entity = (EmployeeTrainingId) o;
        return Objects.equals(this.trainingId, entity.trainingId) &&
                Objects.equals(this.employeeId, entity.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainingId, employeeId);
    }

}