package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Hospital;
import com.heliosync.healthcare.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository repository;

    @Cacheable("hospitals")
    public List<Hospital> findAll() {
        return repository.findAll();
    }

    public Hospital findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Hospital not found"));
    }

    public Hospital save(Hospital entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
