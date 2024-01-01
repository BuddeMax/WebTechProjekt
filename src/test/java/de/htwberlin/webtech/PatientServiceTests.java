package de.htwberlin.webtech;

import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.repository.PatientRepository;
import de.htwberlin.webtech.service.PatientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
@SpringBootTest
public class PatientServiceTests {
    @Autowired
    private PatientService service;

    @MockBean
    private PatientRepository repository;

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
        Patient patient2 = new Patient("Mustermann", "Max");
        patient2.setId(2L);

        doReturn(Optional.of(patient)).when(repository).findById(1L);
        doReturn(Optional.of(patient2)).when(repository).findById(2L);

        Patient returnedPatient = service.get(1L);

        assertEquals("Mustermann", returnedPatient.getName(), "The name should be the same");

    }
}
