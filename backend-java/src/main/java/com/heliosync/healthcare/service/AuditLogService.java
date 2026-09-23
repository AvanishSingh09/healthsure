package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.AuditLog;
import com.heliosync.healthcare.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository repository;

    public List<AuditLog> findAll() {
        return repository.findAll();
    }

    public AuditLog findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("AuditLog not found"));
    }

    public AuditLog save(AuditLog entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
