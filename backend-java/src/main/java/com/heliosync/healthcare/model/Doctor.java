package com.heliosync.healthcare.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "doctors")
public class Doctor implements Serializable {
    @Id
    private String id;
    private String userId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private User user;
    private String hospitalId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Hospital hospital;
    private String specialization;
    private String qualification;
    private String registrationNumber;
    private Integer experience;
    private Double consultationFee;
    private String bio;
    private String profilePhoto;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Appointment> appointments;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Encounter> encounters;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Prescription> prescriptions;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Consent> consents;
}
