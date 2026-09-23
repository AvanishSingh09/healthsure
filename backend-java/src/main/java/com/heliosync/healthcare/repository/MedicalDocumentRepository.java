package com.heliosync.healthcare.repository;

import com.heliosync.healthcare.model.MedicalDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDocumentRepository extends MongoRepository<MedicalDocument, String> {
}
