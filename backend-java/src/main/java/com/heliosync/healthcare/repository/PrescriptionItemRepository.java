package com.heliosync.healthcare.repository;

import com.heliosync.healthcare.model.PrescriptionItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionItemRepository extends MongoRepository<PrescriptionItem, String> {
}
