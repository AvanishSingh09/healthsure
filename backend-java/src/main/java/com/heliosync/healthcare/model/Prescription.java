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
@Document(collection = "prescriptions")
public class Prescription {
    @Id
    private String id;
    private String encounterId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Encounter encounter;
    private String patientId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Patient patient;
    private String doctorId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Doctor doctor;
    private String notes;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<PrescriptionItem> items;
}
