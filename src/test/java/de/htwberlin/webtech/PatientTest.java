package de.htwberlin.webtech;

import de.htwberlin.webtech.entity.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class PatientTest {

    @Test
    void testToString() {
        //Eingabedaten
        String name = "Max";
        String firstname = "Mustermann";

        //"System under test" aufsetzen
        Patient patient = new Patient(name, firstname);
        patient.setId(42L);

        //Erwartetes Ergebnis
        String expected = "Patient{id=42, name='Max', firstname='Mustermann'}";

        //Tatsächliches Ergebnis
        String actual = patient.toString();

        //Vergleich
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        //Eingabedaten
        String name = "Max";
        String firstname = "Mustermann";

        //"System under test" aufsetzen
        Patient patient = new Patient(name, firstname);
        patient.setId(42L);

        Patient patient2 = new Patient(name, firstname);
        patient2.setId(42L);

        //Erwartetes Ergebnis
        boolean expected = true;

        //Tatsächliches Ergebnis
        boolean actual = patient.equals(patient2);

        //Vergleich
        assertEquals(expected, actual);
    }

    @Test
    void testHashCode() {
        //Eingabedaten
        String name = "Max";
        String firstname = "Mustermann";

        //"System under test" aufsetzen
        Patient patient = new Patient(name, firstname);
        patient.setId(42L);

        Patient patient2 = new Patient(name, firstname);
        patient2.setId(42L);

        //Erwartetes Ergebnis
        int expected = patient.hashCode();

        //Tatsächliches Ergebnis
        int actual = patient2.hashCode();

        //Vergleich
        assertEquals(expected, actual);
    }

    @Test
    void testEqualsWithDifferentIds() {
        Patient patient1 = new Patient("Max", "Mustermann");
        patient1.setId(42L);
        Patient patient2 = new Patient("Max", "Mustermann");
        patient2.setId(43L);

        assertFalse(patient1.equals(patient2));
    }

    @Test
    void testEqualsWithDifferentNames() {
        Patient patient1 = new Patient("Max", "Mustermann");
        patient1.setId(42L);
        Patient patient2 = new Patient("Moritz", "Mustermann");
        patient2.setId(42L);

        assertFalse(patient1.equals(patient2));
    }

    @Test
    void testEqualsWithDifferentFirstnames() {
        Patient patient1 = new Patient("Max", "Mustermann");
        patient1.setId(42L);
        Patient patient2 = new Patient("Max", "Musterfrau");
        patient2.setId(42L);

        assertFalse(patient1.equals(patient2));
    }

    @Test
    void testCalculateAge() {
        Patient patient = new Patient("Max", "Mustermann");
        patient.setBirthDate(LocalDate.of(2000, 1, 1));
        assertEquals(24, patient.calculateAge()); // Angenommen, das aktuelle Jahr ist 2024
    }

    @Test
    void testSetterAndGetter() {
        Patient patient = new Patient();
        patient.setId(42L);
        patient.setName("Max");
        patient.setFirstname("Mustermann");
        patient.setAge(24);
        patient.setBirthDate(LocalDate.of(2000, 1, 1));
        patient.setGender("Männlich");
        patient.setNote("Notiz");

        assertEquals(42L, patient.getId());
        assertEquals("Max", patient.getName());
        assertEquals("Mustermann", patient.getFirstname());
        assertEquals(24, patient.getAge());
        assertEquals(LocalDate.of(2000, 1, 1), patient.getBirthDate());
        assertEquals("Männlich", patient.getGender());
        assertEquals("Notiz", patient.getNote());
    }

    @Test
    void testEqualsAndHashCodeConsistency() {
        Patient patient1 = new Patient("Max", "Mustermann");
        patient1.setId(42L);
        Patient patient2 = new Patient("Max", "Mustermann");
        patient2.setId(42L);

        assertTrue(patient1.equals(patient2));
        assertEquals(patient1.hashCode(), patient2.hashCode());
    }

    @Test
    void testConstructor() {
        Patient patient = new Patient("Max", "Mustermann");
        assertEquals("Max", patient.getName());
        assertEquals("Mustermann", patient.getFirstname());
    }

    @Test
    void testNullValues() {
        Patient patient = new Patient(null, null);
        patient.setId(null);

        assertNotNull(patient.toString());
        assertDoesNotThrow(() -> patient.hashCode());
        assertDoesNotThrow(() -> patient.equals(new Patient(null, null)));
    }

    @Test
    void testCalculateAgeWithFutureBirthDate() {
        Patient patient = new Patient("Max", "Mustermann");
        patient.setBirthDate(LocalDate.now().plusYears(1)); // Ein Geburtsdatum in der Zukunft

        assertThrows(IllegalArgumentException.class, patient::calculateAge);
    }
}
