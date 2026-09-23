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
@Document(collection = "prescriptionitems")
public class PrescriptionItem {
    @Id
    private String id;
    private String prescriptionId;
    @org.springframework.data.mongodb.core.mapping.DocumentReference
    private Prescription prescription;
    private String medicineName;
    private String dosage;
    private String frequency;
    private String duration;
    private String instructions;
    private Integer quantity;
}
