package com.heliosync.healthcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "medicaldocuments")
public class MedicalDocument {
    @Id
    private String id;
    private String patientId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Patient patient;
    private String uploadedBy;
    private String documentType;
    private String fileName;
    private String filePath;
    private String description;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
}
