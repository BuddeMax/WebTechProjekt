package de.htwberlin.webtech.service;

import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.service.PatientService;
import de.htwberlin.webtech.controller.PatientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository repo;

    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    public Patient get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Patient> getAll() {
        Iterable<Patient> iterator = repo.findAll();
        List<Patient> patients = new ArrayList<Patient>();
        for (Patient thing : iterator)  patients.add(thing);
        return patients;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
