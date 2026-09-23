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
@Document(collection = "vitalss")
public class Vitals {
    @Id
    private String id;
    private String encounterId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Encounter encounter;
    private String patientId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Patient patient;
    private String bloodPressure;
    private Integer heartRate;
    private Double temperature;
    private Integer spo2;
    private Integer respiratoryRate;
    private Double weight;
    private Double height;
    private java.time.LocalDateTime recordedAt;
}
