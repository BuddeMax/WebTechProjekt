package de.htwberlin.webtech.service;

import de.htwberlin.webtech.entity.File;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.entity.ToDo;
import de.htwberlin.webtech.entity.VitalSigns;
import de.htwberlin.webtech.repository.PatientRepository;
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

    // Überarbeitete Methode für die Aktualisierung eines Patienten
    public Patient update(Long id, Patient updatedPatient) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());

        // Setze die aktualisierten Werte
        existingPatient.setUsername(updatedPatient.getUsername());
        existingPatient.setPassword(updatedPatient.getPassword());
        existingPatient.setBed(updatedPatient.getBed());
        existingPatient.setArea(updatedPatient.getArea());
        existingPatient.setResponsiblePhysician(updatedPatient.getResponsiblePhysician());
        existingPatient.setResponsibleNurse(updatedPatient.getResponsibleNurse());
        existingPatient.setVitalSigns(updatedPatient.getVitalSigns());
        existingPatient.setNote(updatedPatient.getNote());

        // Speichere die Aktualisierung in der Datenbank
        return repo.save(existingPatient);
    }

    // Neue Methode für die Abfrage der File-Liste eines Patienten
    public List<File> getFiles(Long id) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        return existingPatient.getFiles();
    }

    // Neue Methode für die Abfrage eines Files
    public File getFile(Long id, Long fileId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<File> files = existingPatient.getFiles();
        for (File file : files) {
            if (file.getId().equals(fileId)) {
                return file;
            }
        }
        return null;
    }

    // Neue Methode für die Erstellung eines Files
    public File createFile(Long id, File file) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        existingPatient.addFile(file);
        return repo.save(existingPatient).getFile(file.getId());
    }

    // Neue Methode für das Update eines Files
    public File updateFile(Long id, Long fileId, File updatedFile) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<File> files = existingPatient.getFiles();
        for (File file : files) {
            if (file.getId().equals(fileId)) {
                file.setFileName(updatedFile.getFileName());
                file.setFilePath(updatedFile.getFilePath());
                file.setDescription(updatedFile.getDescription());
                return repo.save(existingPatient).getFile(file.getId());
            }
        }
        return null;
    }

    // Neue Methode für das Löschen eines Files
    public void deleteFile(Long id, Long fileId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<File> files = existingPatient.getFiles();
        for (File file : files) {
            if (file.getId().equals(fileId)) {
                existingPatient.removeFile(file);
                repo.save(existingPatient);
                return;
            }
        }
    }
    // Neue Methode für die Abfrage der VitalSigns-Liste eines Patienten
    public List<VitalSigns> getVitalSigns(Long id) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        return existingPatient.getVitalSigns();
    }

    // Neue Methode für die Abfrage eines VitalSigns
    public VitalSigns getVitalSign(Long id, Long vitalSignId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<VitalSigns> vitalSigns = existingPatient.getVitalSigns();
        for (VitalSigns vitalSign : vitalSigns) {
            if (vitalSign.getId().equals(vitalSignId)) {
                return vitalSign;
            }
        }
        return null;
    }

    // Neue Methode für die Erstellung eines VitalSigns
    public VitalSigns createVitalSign(Long id, VitalSigns vitalSign) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        existingPatient.addVitalSign(vitalSign);
        return repo.save(existingPatient).getVitalSign(vitalSign.getId());
    }

    // Neue Methode für das Update eines VitalSigns
    public VitalSigns updateVitalSign(Long id, Long vitalSignId, VitalSigns updatedVitalSign) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<VitalSigns> vitalSigns = existingPatient.getVitalSigns();
        for (VitalSigns vitalSign : vitalSigns) {
            if (vitalSign.getId().equals(vitalSignId)) {
                vitalSign.setHeartRate(updatedVitalSign.getHeartRate());
                vitalSign.setBloodPressure(updatedVitalSign.getBloodPressure());
                vitalSign.setTemperature(updatedVitalSign.getTemperature());
                vitalSign.setOxygenSaturation(updatedVitalSign.getOxygenSaturation());
                return repo.save(existingPatient).getVitalSign(vitalSign.getId());
            }
        }
        return null;
    }

    // Neue Methode für das Löschen eines VitalSigns
    public void deleteVitalSign(Long id, Long vitalSignId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<VitalSigns> vitalSigns = existingPatient.getVitalSigns();
        for (VitalSigns vitalSign : vitalSigns) {
            if (vitalSign.getId().equals(vitalSignId)) {
                existingPatient.removeVitalSign(vitalSign);
                repo.save(existingPatient);
                return;
            }
        }
    }

    // Neue Methode für die Abfrage der ToDo-Liste eines Patienten
    public List<ToDo> getToDos(Long id) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        return existingPatient.getToDos();
    }

    // Neue Methode für die Abfrage eines ToDo
    public ToDo getToDos(Long id, Long toDoId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<ToDo> toDos = existingPatient.getToDos();
        for (ToDo toDo : toDos) {
            if (toDo.getToDoId().equals(toDoId)) {
                return toDo;
            }
        }
        return null;
    }

    // Neue Methode für die Erstellung eines ToDo
    public ToDo createToDo (Long id, ToDo toDo) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        existingPatient.addToDo (toDo);
        return repo.save(existingPatient).getToDo (toDo.getToDoId());
    }

    // Neue Methode für das Update eines ToDo
    public ToDo updateToDo (Long id, Long toDoId, ToDo updatedToDo) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<ToDo> toDos = existingPatient.getToDos();
        for (ToDo toDo : toDos) {
            if (toDo.getToDoId().equals(toDoId)) {
                toDo.setBeschreibung(updatedToDo.getBeschreibung());
                toDo.setPrioritaet(updatedToDo.getPrioritaet());
                toDo.setStatus(updatedToDo.getStatus());
                return repo.save(existingPatient).getToDo (toDo.getToDoId());
            }
        }
        return null;
    }

    // Neue Methode für das Löschen eines ToDo
    public void deleteToDo (Long id, Long toDoId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        List<ToDo> toDos = existingPatient.getToDos();
        for (ToDo toDo : toDos) {
            if (toDo.getToDoId().equals(toDoId)) {
                existingPatient.removeToDo (toDo);
                repo.save(existingPatient);
                return;
            }
        }
    }


}


