package de.htwberlin.webtech;

import de.htwberlin.webtech.controller.PatientController;
import de.htwberlin.webtech.entity.Patient;
import de.htwberlin.webtech.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService service;

    @Test
    public void testGetRoute() throws Exception {
        Patient patient = new Patient("Mustermann", "Max");
        patient.setId(1L);
        when(service.get(1L)).thenReturn(patient);

        String expected = "{\"id\":1,\"name\":\"Mustermann\",\"firstname\":\"Max\",\"age\":0,\"birthDate\":null,\"gender\":null,\"note\":null}";

        this.mockMvc.perform(get("/patient/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testGetAllRoute() throws Exception {
        Patient patient = new Patient("Mustermann", "Max");
        patient.setId(1L);
        Patient patient2 = new Patient("Mueller", "Lisa");
        patient2.setId(2L);
        when(service.getAll()).thenReturn(java.util.List.of(patient, patient2));

        String expected = "[{\"id\":1,\"name\":\"Mustermann\",\"firstname\":\"Max\",\"age\":0,\"birthDate\":null,\"gender\":null,\"note\":null},{\"id\":2,\"name\":\"Mueller\",\"firstname\":\"Lisa\",\"age\":0,\"birthDate\":null,\"gender\":null,\"note\":null}]";

        this.mockMvc.perform(get("/patients"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

}
