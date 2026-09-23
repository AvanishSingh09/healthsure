package com.heliosync.healthcare.repository;

import com.heliosync.healthcare.model.Encounter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends MongoRepository<Encounter, String> {
}
