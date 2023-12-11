package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UniversalController {

    @Autowired
    private UniversalService universalService;

    @PostMapping("/{entity}")
    public ResponseEntity<?> createEntity(@PathVariable String entity, @RequestBody Object object) {
        return ResponseEntity.ok(universalService.create(entity, object));
    }

    @GetMapping("/{entity}/{id}")
    public ResponseEntity<?> getEntity(@PathVariable String entity, @PathVariable Long id) {
        return ResponseEntity.ok(universalService.get(entity, id));
    }

    @GetMapping("/{entity}/all")
    public ResponseEntity<?> getAllEntities(@PathVariable String entity) {
        return ResponseEntity.ok(universalService.getAll(entity));
    }

    @PutMapping("/{entity}/{id}")
    public ResponseEntity<?> updateEntity(@PathVariable String entity, @PathVariable Long id, @RequestBody Object object) {
        return ResponseEntity.ok(universalService.update(entity, id, object));
    }

    @DeleteMapping("/{entity}/{id}")
    public void deleteEntity(@PathVariable String entity, @PathVariable Long id) {
        universalService.delete(entity, id);
    }
}

