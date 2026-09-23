package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Vitals;
import com.heliosync.healthcare.repository.VitalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VitalsService {

    private final VitalsRepository repository;

    public List<Vitals> findAll() {
        return repository.findAll();
    }

    public Vitals findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Vitals not found"));
    }

    public Vitals save(Vitals entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
