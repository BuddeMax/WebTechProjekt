package de.htwberlin.webtech;

import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PatientServiceTests {
    @Autowired
    private PatientService service;

    @MockBean
    private PatientRepository repository;

    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient("Mustermann", "Max");
        patient.setId(1L);
    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
        Patient patient = new Patient("Mustermann", "Max");
        patient.setId(1L);
        doReturn(Optional.of(patient)).when(repository).findById(1L);

        // Execute the service call
        Patient returnedPatient = service.get(1L);

        // Assert the response
        assertEquals("Mustermann", returnedPatient.getName(), "The name should be the same");
    }

    @Test
    @DisplayName("Test findById")
    void testFindByIdTwo(){
        Patient patient = new Patient("Mustermann", "Max");
        patient.setId(1L);
        Patient patient2 = new Patient("Mueller", "Lisa");
        patient2.setId(2L);

        doReturn(Optional.of(patient)).when(repository).findById(1L);
        doReturn(Optional.of(patient2)).when(repository).findById(2L);

        Patient returnedPatient = service.get(2L);

        assertEquals("Mueller", returnedPatient.getName(), "The name should be the same");

    }

    @Test
    @DisplayName("Test save Patient")
    void testSavePatient() {
        doReturn(patient).when(repository).save(any(Patient.class));
        Patient savedPatient = service.save(new Patient("Neu", "Patient"));
        assertNotNull(savedPatient);
    }

    @Test
    @DisplayName("Test getAll Patients")
    void testGetAllPatients() {
        doReturn(Arrays.asList(patient)).when(repository).findAll();
        List<Patient> patients = service.getAll();
        assertFalse(patients.isEmpty());
        assertEquals(1, patients.size());
    }

    @Test
    @DisplayName("Test delete Patient")
    void testDeletePatient() {
        doNothing().when(repository).deleteById(1L);
        assertDoesNotThrow(() -> service.delete(1L));
    }

    @Test
    @DisplayName("Test deleteAll Patients")
    void testDeleteAllPatients() {
        doNothing().when(repository).deleteAll();
        assertDoesNotThrow(() -> service.deleteAll());
    }

    @Test
    @DisplayName("Test update Patient")
    void testUpdatePatient() {
        Patient updatedPatient = new Patient("Geändert", "Patient");
        updatedPatient.setId(1L);
        updatedPatient.setNote("Neue Notiz");

        doReturn(Optional.of(patient)).when(repository).findById(1L);
        doReturn(updatedPatient).when(repository).save(any(Patient.class));

        Patient patientToUpdate = service.update(1L, updatedPatient);

        assertNotNull(patientToUpdate);
        assertEquals(updatedPatient.getNote(), patientToUpdate.getNote());
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        doReturn(Optional.empty()).when(repository).findById(1L);
        assertThrows(RuntimeException.class, () -> service.get(1L));
    }

    @Test
    @DisplayName("Test update Nonexistent Patient")
    void testUpdateNonexistentPatient() {
        doReturn(Optional.empty()).when(repository).findById(1L);
        assertThrows(RuntimeException.class, () -> service.update(1L, new Patient("Nicht", "Vorhanden")));
    }
}
