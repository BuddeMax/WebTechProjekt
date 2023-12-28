package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.File;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.repository.FileRepository;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.service.FileService;
import de.htwberlin.webtech.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private PatientService patientService;

    Logger logger = LoggerFactory.getLogger(PatientController.class);


    @GetMapping("/file/{id}")
    public File getFile(@PathVariable Long id) {
        return fileService.get(id);
    }

    @PostMapping("/file")
    public File createFile(@RequestBody File file) {
        return fileService.save(file);
    }

    // get all files
    @GetMapping("/files")
    public Iterable<File> getAllFiles() {
        return fileService.getAll();
    }

    // Put an existing File to an existing Patient
    @PutMapping("/file/{fileId}/patient/{patientId}")
    public File assignFileToPatient(@PathVariable Long fileId, @PathVariable Long patientId) {
        File file = fileService.get(fileId);
        Patient patient = patientService.get(patientId);
        file.assignPatient(patient);
        return fileService.save(file);
    }

    //Delete a file from a patient
    @DeleteMapping("/file/{fileId}/patient/{patientId}")
    public void deleteFileFromPatient(@PathVariable Long fileId, @PathVariable Long patientId) {
        File file = fileService.get(fileId);
        Patient patient = patientService.get(patientId);
        file.assignPatient(null);
        fileService.save(file);
    }

    // Get all files from a patient
    @GetMapping("/patient/{patientId}/files")
    public Iterable<File> getAllFilesFromPatient(@PathVariable Long patientId) {
        Patient patient = patientService.get(patientId);
        return patient.getFiles();
    }


}
