package com.vinesh.hrms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "document_types")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type_name", nullable = false, length = 100)
    private String typeName;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "documentType")
    private Set<com.vinesh.hrms.model.Document> documents = new LinkedHashSet<>();

}