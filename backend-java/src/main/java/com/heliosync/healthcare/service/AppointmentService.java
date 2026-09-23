package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.Appointment;
import com.heliosync.healthcare.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;

    public List<Appointment> findAll() {
        return repository.findAll();
    }

    public Appointment findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment save(Appointment entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
