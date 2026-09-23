package com.heliosync.healthcare.controller;

import com.heliosync.healthcare.model.Vitals;
import com.heliosync.healthcare.service.VitalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vitalss")
@RequiredArgsConstructor
public class VitalsController {

    private final VitalsService service;

    @GetMapping
    public ResponseEntity<List<Vitals>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vitals> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Vitals> create(@RequestBody Vitals entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vitals> update(@PathVariable String id, @RequestBody Vitals entity) {
        entity.setId(id);
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
