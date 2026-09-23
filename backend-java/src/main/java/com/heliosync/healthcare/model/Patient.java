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
@Document(collection = "patients")
public class Patient {
    @Id
    private String id;
    private String userId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private User user;
    private String patientNumber;
    private java.time.LocalDateTime dateOfBirth;
    private String gender;
    private String bloodGroup;
    private String phone;
    private String address;
    private String emergencyContact;
    private String emergencyContactPhone;
    private String allergies;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Appointment> appointments;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Encounter> encounters;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Vitals> vitals;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Prescription> prescriptions;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<MedicalDocument> documents;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Consent> consents;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<AuditLog> auditLogs;
}
