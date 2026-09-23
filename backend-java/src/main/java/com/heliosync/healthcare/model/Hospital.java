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
@Document(collection = "hospitals")
public class Hospital implements Serializable {
    @Id
    private String id;
    private String name;
    private String registrationNumber;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String email;
    private String logo;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Doctor> doctors;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Appointment> appointments;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Encounter> encounters;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<Consent> consents;
}
