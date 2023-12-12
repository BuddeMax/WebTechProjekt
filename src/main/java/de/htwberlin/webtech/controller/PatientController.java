package de.htwberlin.webtech.controller;

import de.htwberlin.webtech.entity.File;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.entity.ToDo;
import de.htwberlin.webtech.entity.VitalSigns;
import de.htwberlin.webtech.service.PatientService;
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

    // Neue Methode für die Aktualisierung eines Patienten
    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        logger.info("PUT request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.update(patientId, updatedPatient);
    }

    // Neue Methode für die Abfrage eines Files
    @GetMapping("/patient/{id}/file/{fileId}")
    public File getFile(@PathVariable String id, @PathVariable String fileId) {
        logger.info("GET request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long fileIdLong = Long.parseLong(fileId);
        return service.getFile(patientId, fileIdLong);
    }

    // Neue Methode für die Abfrage der File-Liste eines Patienten
    @GetMapping("/patient/{id}/files")
    public List<File> getFiles(@PathVariable String id) {
        logger.info("GET request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.getFiles(patientId);
    }

    // Neue Methode für die Erstellung eines Files
    @PostMapping("/patient/{id}/files")
    public File createFile(@PathVariable String id, @RequestBody File file) {
        logger.info("POST request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.createFile(patientId, file);
    }

    // Neue Methode für das Update eines Files
    @PutMapping("/patient/{id}/file/{fileId}")
    public File updateFile(@PathVariable String id, @PathVariable String fileId, @RequestBody File updatedFile) {
        logger.info("PUT request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long fileIdLong = Long.parseLong(fileId);
        return service.updateFile(patientId, fileIdLong, updatedFile);
    }

    // Neue Methode für das Löschen eines Files
    @DeleteMapping("/patient/{id}/file/{fileId}")
    public void deleteFile(@PathVariable String id, @PathVariable String fileId) {
        logger.info("DELETE request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long fileIdLong = Long.parseLong(fileId);
        service.deleteFile(patientId, fileIdLong);
    }

    // Neue Methode für die Abfrage eines ToDos
    @GetMapping("/patient/{id}/todo/{toDoId}")
    public ToDo getToDo(@PathVariable String id, @PathVariable String toDoId) {
        logger.info("GET request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long toDoIdLong = Long.parseLong(toDoId);
        return service.getToDos(patientId, toDoIdLong);
    }

    // Neue Methode für die Abfrage der ToDo-Liste eines Patienten
    @GetMapping("/patient/{id}/todos")
    public List<ToDo> getToDos(@PathVariable String id) {
        logger.info("GET request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.getToDos(patientId);
    }

    // Neue Methode für die Erstellung eines ToDos
    @PostMapping("/patient/{id}/todo")
    public ToDo createToDo(@PathVariable String id, @RequestBody ToDo toDo) {
        logger.info("POST request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.createToDo(patientId, toDo);
    }

    // Neue Methode für das Update eines ToDos
    @PutMapping("/patient/{id}/todo/{toDoId}")
    public ToDo updateToDo(@PathVariable String id, @PathVariable String toDoId, @RequestBody ToDo updatedToDo) {
        logger.info("PUT request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long toDoIdLong = Long.parseLong(toDoId);
        return service.updateToDo(patientId, toDoIdLong, updatedToDo);
    }

    // Neue Methode für das Löschen eines ToDo
    @DeleteMapping("/patient/{id}/todo/{toDoId}")
    public void deleteToDo(@PathVariable String id, @PathVariable String toDoId) {
        logger.info("DELETE request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long toDoIdLong = Long.parseLong(toDoId);
        service.deleteToDo (patientId, toDoIdLong);
    }

    // Neue Methode für die Abfrage eines VitalSigns
    @GetMapping("/patient/{id}/vitalsign/{vitalSignId}")
    public VitalSigns getVitalSign(@PathVariable String id, @PathVariable String vitalSignId) {
        logger.info("GET request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long vitalSignIdLong = Long.parseLong(vitalSignId);
        return service.getVitalSign(patientId, vitalSignIdLong);
    }

    // Neue Methode für die Abfrage der VitalSign-Liste eines Patienten
    @GetMapping("/patient/{id}/vitalsigns")
    public List<VitalSigns> getVitalSigns(@PathVariable String id) {
        logger.info("GET request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.getVitalSigns(patientId);
    }

    // Neue Methode für die Erstellung eines VitalSigns
    @PostMapping("/patient/{id}/vitalsign")
    public VitalSigns createVitalSign(@PathVariable String id, @RequestBody VitalSigns vitalSign) {
        logger.info("POST request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        return service.createVitalSign(patientId, vitalSign);
    }

    // Neue Methode für das Update eines VitalSigns
    @PutMapping("/patient/{id}/vitalsign/{vitalSignId}")
    public VitalSigns updateVitalSign(@PathVariable String id, @PathVariable String vitalSignId, @RequestBody VitalSigns updatedVitalSign) {
        logger.info("PUT request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long vitalSignIdLong = Long.parseLong(vitalSignId);
        return service.updateVitalSign(patientId, vitalSignIdLong, updatedVitalSign);
    }

    // Neue Methode für das Löschen eines VitalSigns
    @DeleteMapping("/patient/{id}/vitalsign/{vitalSignId}")
    public void deleteVitalSign(@PathVariable String id, @PathVariable String vitalSignId) {
        logger.info("DELETE request on route patient with {}", id);
        Long patientId = Long.parseLong(id);
        Long vitalSignIdLong = Long.parseLong(vitalSignId);
        service.deleteVitalSign(patientId, vitalSignIdLong);
    }

}


