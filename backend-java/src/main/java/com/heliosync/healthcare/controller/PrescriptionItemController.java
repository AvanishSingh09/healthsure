package com.heliosync.healthcare.controller;

import com.heliosync.healthcare.model.PrescriptionItem;
import com.heliosync.healthcare.service.PrescriptionItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptionitems")
@RequiredArgsConstructor
public class PrescriptionItemController {

    private final PrescriptionItemService service;

    @GetMapping
    public ResponseEntity<List<PrescriptionItem>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionItem> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PrescriptionItem> create(@RequestBody PrescriptionItem entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionItem> update(@PathVariable String id, @RequestBody PrescriptionItem entity) {
        entity.setId(id);
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
