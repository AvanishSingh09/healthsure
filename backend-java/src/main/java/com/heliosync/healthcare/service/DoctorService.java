package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Doctor;
import com.heliosync.healthcare.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;

    @Cacheable("doctors")
    public List<Doctor> findAll() {
        return repository.findAll();
    }

    public Doctor findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor save(Doctor entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
