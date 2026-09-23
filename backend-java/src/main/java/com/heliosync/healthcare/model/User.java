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
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String passwordHash;
    private String role;
    private Boolean isActive;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Doctor doctor;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Patient patient;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private java.util.List<AuditLog> auditLogs;
}
