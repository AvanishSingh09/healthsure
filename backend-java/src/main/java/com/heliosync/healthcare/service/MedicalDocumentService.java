package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.MedicalDocument;
import com.heliosync.healthcare.repository.MedicalDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalDocumentService {

    private final MedicalDocumentRepository repository;

    public List<MedicalDocument> findAll() {
        return repository.findAll();
    }

    public MedicalDocument findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("MedicalDocument not found"));
    }

    public MedicalDocument save(MedicalDocument entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
