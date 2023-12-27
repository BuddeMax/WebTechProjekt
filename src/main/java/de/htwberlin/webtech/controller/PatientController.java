package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.File;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.entity.ToDo;
import de.htwberlin.webtech.entity.VitalSigns;
import de.htwberlin.webtech.repository.FileRepository;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        logger.info("GET request on route patient with {}", id);
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

    //Delete all patients
    @DeleteMapping("/patients/delete")
    public void deleteAllPatients() {
        logger.info("DELETE request on route patients");
        service.deleteAll();
    }

    // Neue Methode für die Aktualisierung eines Patienten
    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        logger.info("PUT request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.update(patientId, updatedPatient);
    }


}


