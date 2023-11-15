package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.service.PatientService;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.controller.PatientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class PatientController {

    @Autowired
    PatientService service;

    Logger logger = LoggerFactory.getLogger(PatientController.class);

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long patientId = Long.parseLong(id);
        return service.get(patientId);
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatient() {
        return service.getAll();
    }

    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable String id) {
        logger.info("DELETE request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        service.delete(patientId);
    }

}

