package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Encounter;
import com.heliosync.healthcare.repository.EncounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EncounterService {

    private final EncounterRepository repository;

    public List<Encounter> findAll() {
        return repository.findAll();
    }

    public Encounter findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Encounter not found"));
    }

    public Encounter save(Encounter entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
