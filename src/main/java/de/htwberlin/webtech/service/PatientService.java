package de.htwberlin.webtech.service;

import de.htwberlin.webtech.entity.File;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.entity.ToDo;
import de.htwberlin.webtech.entity.VitalSigns;
import de.htwberlin.webtech.repository.FileRepository;
import de.htwberlin.webtech.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PatientService {

    @Autowired
    PatientRepository repo;

    @Autowired
    private PatientRepository patientRepository; // Annahme der Repository-Instanzen

    @Autowired
    private FileRepository fileRepository;

    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    public Patient get(Long id) {
        return repo.findById(id).orElseThrow(() ->  new RuntimeException());
    }

    public List<Patient> getAll() {
        Iterable<Patient> iterator = repo.findAll();
        List<Patient> patients = new ArrayList<>();
        for (Patient thing : iterator) patients.add(thing);
        return patients;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    // Überarbeitete Methode für die Aktualisierung eines Patienten
    public Patient update(Long id, Patient updatedPatient) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());

        // Setze die aktualisierten Werte
        existingPatient.setNote(updatedPatient.getNote());

        // Speichere die Aktualisierung in der Datenbank
        return repo.save(existingPatient);
    }


}


