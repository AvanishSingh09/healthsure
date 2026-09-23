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
@Document(collection = "consents")
public class Consent {
    @Id
    private String id;
    private String patientId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Patient patient;
    private String doctorId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Doctor doctor;
    private String hospitalId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Hospital hospital;
    private String appointmentId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Appointment appointment;
    private String purpose;
    private String status;
    private Boolean canViewHistory;
    private Boolean canViewVitals;
    private Boolean canViewPrescriptions;
    private Boolean canViewReports;
    private java.time.LocalDateTime expiresAt;
    private java.time.LocalDateTime grantedAt;
    private java.time.LocalDateTime revokedAt;
    private java.time.LocalDateTime createdAt;
}
