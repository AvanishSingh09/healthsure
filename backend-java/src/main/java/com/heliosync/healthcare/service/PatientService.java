package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Patient;
import com.heliosync.healthcare.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient save(Patient entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
