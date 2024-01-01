package de.htwberlin.webtech;

import de.htwberlin.webtech.entity.Patient;
import org.junit.jupiter.api.Test;

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
}
