package com.heliosync.healthcare.service;

import com.heliosync.healthcare.model.PrescriptionItem;
import com.heliosync.healthcare.repository.PrescriptionItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionItemService {

    private final PrescriptionItemRepository repository;

    public List<PrescriptionItem> findAll() {
        return repository.findAll();
    }

    public PrescriptionItem findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("PrescriptionItem not found"));
    }

    public PrescriptionItem save(PrescriptionItem entity) {
        return repository.save(entity);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
