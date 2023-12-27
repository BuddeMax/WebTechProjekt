package de.htwberlin.webtech.service;

import de.htwberlin.webtech.entity.File;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.repository.FileRepository;
import de.htwberlin.webtech.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private PatientRepository patientRepository;

    public File save(File file) {
        return fileRepository.save(file);
    }

    public File get(Long id) {
        return fileRepository.findById(id).get();
    }

    public Iterable<File> getAll() {
        return fileRepository.findAll();
    }

    public void delete(Long id) {
        fileRepository.deleteById(id);
    }

    public void deleteAll() {
        fileRepository.deleteAll();
    }


}
