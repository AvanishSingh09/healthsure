package com.heliosync.healthcare.controller;

import com.heliosync.healthcare.model.MedicalDocument;
import com.heliosync.healthcare.service.MedicalDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicaldocuments")
@RequiredArgsConstructor
public class MedicalDocumentController {

    private final MedicalDocumentService service;

    @GetMapping
    public ResponseEntity<List<MedicalDocument>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalDocument> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<MedicalDocument> create(@RequestBody MedicalDocument entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalDocument> update(@PathVariable String id, @RequestBody MedicalDocument entity) {
        entity.setId(id);
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
