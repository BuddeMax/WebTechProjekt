package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.service.PatientService;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.controller.PatientController;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> { }
