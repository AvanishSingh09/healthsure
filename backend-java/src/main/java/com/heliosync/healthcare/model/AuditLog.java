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
@Document(collection = "auditlogs")
public class AuditLog {
    @Id
    private String id;
    private String userId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private User user;
    private String patientId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Patient patient;
    private String action;
    private String resourceType;
    private String resourceId;
    private String metadata;
    private java.time.LocalDateTime timestamp;
}
