package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Prescription;
import com.heliosync.healthcare.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository repository;

    public List<Prescription> findAll() {
        return repository.findAll();
    }

    public Prescription findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Prescription not found"));
    }

    public Prescription save(Prescription entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
