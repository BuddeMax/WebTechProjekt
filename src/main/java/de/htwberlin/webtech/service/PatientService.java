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
    public Set<File> getFiles(Long id) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        return existingPatient.getFiles();
    }

    // Neue Methode für die Abfrage eines Files
    public File getFile(Long id, Long fileId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        Set<File> files = existingPatient.getFiles();
        for (File file : files) {
            if (file.getId().equals(fileId)) {
                return file;
            }
        }
        return null;
    }

    public File createFile(File file) {
        // Hier wird das File zuerst erstellt
        File createdFile = fileRepository.save(file);
        return createdFile;
    }

    public File assignFileToPatient(Long patientId, Long fileId) {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        File file = fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found"));

        existingPatient.addFile(file);
        patientRepository.save(existingPatient);

        return file;
    }

    // Neue Methode für das Update eines Files
    public File updateFile(Long id, Long fileId, File updatedFile) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        Set<File> files = existingPatient.getFiles();
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
        Set<File> files = existingPatient.getFiles();
        for (File file : files) {
            if (file.getId().equals(fileId)) {
                existingPatient.removeFile(file);
                repo.save(existingPatient);
                return;
            }
        }
    }
    // Neue Methode für die Abfrage der VitalSigns-Liste eines Patienten
    public Set<VitalSigns> getVitalSigns(Long id) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        return existingPatient.getVitalSigns();
    }

    // Neue Methode für die Abfrage eines VitalSigns
    public VitalSigns getVitalSign(Long id, Long vitalSignId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        Set<VitalSigns> vitalSigns = existingPatient.getVitalSigns();
        for (VitalSigns vitalSign : vitalSigns) {
            if (vitalSign.getVitalSignId().equals(vitalSignId)) {
                return vitalSign;
            }
        }
        return null;
    }

    // Neue Methode für die Erstellung eines VitalSigns
    public VitalSigns createVitalSign(Long id, VitalSigns vitalSign) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        existingPatient.addVitalSign(vitalSign);
        return repo.save(existingPatient).getVitalSign(vitalSign.getVitalSignId());
    }

    // Neue Methode für das Update eines VitalSigns
    public VitalSigns updateVitalSign(Long id, Long vitalSignId, VitalSigns updatedVitalSign) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        Set<VitalSigns> vitalSigns = existingPatient.getVitalSigns();
        for (VitalSigns vitalSign : vitalSigns) {
            if (vitalSign.getVitalSignId().equals(vitalSignId)) {
                vitalSign.setHeartRate(updatedVitalSign.getHeartRate());
                vitalSign.setBloodPressure(updatedVitalSign.getBloodPressure());
                vitalSign.setTemperature(updatedVitalSign.getTemperature());
                vitalSign.setOxygenSaturation(updatedVitalSign.getOxygenSaturation());
                return repo.save(existingPatient).getVitalSign(vitalSign.getVitalSignId());
            }
        }
        return null;
    }

    // Neue Methode für das Löschen eines VitalSigns
    public void deleteVitalSign(Long id, Long vitalSignId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        Set<VitalSigns> vitalSigns = existingPatient.getVitalSigns();
        for (VitalSigns vitalSign : vitalSigns) {
            if (vitalSign.getVitalSignId().equals(vitalSignId)) {
                existingPatient.removeVitalSign(vitalSign);
                repo.save(existingPatient);
                return;
            }
        }
    }

    // Neue Methode für die Abfrage der ToDo-Liste eines Patienten
    public Set<ToDo> getToDos(Long id) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        return existingPatient.getToDos();
    }

    // Neue Methode für die Abfrage eines ToDo
    public ToDo getToDos(Long id, Long toDoId) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        Set<ToDo> toDos = existingPatient.getToDos();
        for (ToDo toDo : toDos) {
            if (toDo.getToDoId().equals(toDoId)) {
                return toDo;
            }
        }
        return null;
    }

    /** Neue Methode für die Erstellung eines ToDo, die anfangs erst das Objekt ToDo erstellt und
     * dieses dann in Datenbank speichert. Anschließend wird das ToDo-Objekt aus der Datenbank
     * dem Patienten hinzugefügt und der Patient in der Datenbank gespeichert.
     * @param id
     * @return
     */
    public ToDo createToDo (Long id, ToDo toDo) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        existingPatient.addToDo(toDo);
        return repo.save(existingPatient).getToDo(toDo.getToDoId());
    }


    // Neue Methode für das Update eines ToDo
    public ToDo updateToDo (Long id, Long toDoId, ToDo updatedToDo) {
        Patient existingPatient = repo.findById(id).orElseThrow(() -> new RuntimeException());
        Set<ToDo> toDos = existingPatient.getToDos();
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
        Set<ToDo> toDos = existingPatient.getToDos();
        for (ToDo toDo : toDos) {
            if (toDo.getToDoId().equals(toDoId)) {
                existingPatient.removeToDo (toDo);
                repo.save(existingPatient);
                return;
            }
        }
    }


}


