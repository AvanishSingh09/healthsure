package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Consent;
import com.heliosync.healthcare.repository.ConsentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsentService {

    private final ConsentRepository repository;

    public List<Consent> findAll() {
        return repository.findAll();
    }

    public Consent findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Consent not found"));
    }

    public Consent save(Consent entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
