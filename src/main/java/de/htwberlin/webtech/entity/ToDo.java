package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import de.htwberlin.webtech.entity.*;
import org.springframework.data.annotation.Persistent;

import java.time.LocalDateTime;

@Entity
@Table(name = "toDo")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String beschreibung;
    private String prioritaet;
    private String status;
    private LocalDateTime recordingTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    public ToDo() {
    }

    public ToDo(String beschreibung, String prioritaet, String status, LocalDateTime recordingTime) {
        this.beschreibung = beschreibung;
        this.prioritaet = prioritaet;
        this.status = status;
        this.recordingTime = recordingTime;
    }

    // Getter für toDoId
    public Long getToDoId() {
        return id;
    }

    // Setter für toDoId
    public void setToDoId(Long id) {
        this.id = id;
    }

    // Getter für beschreibung
    public String getBeschreibung() {
        return beschreibung;
    }

    // Setter für beschreibung
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    // Getter für prioritaet
    public String getPrioritaet() {
        return prioritaet;
    }

    // Setter für prioritaet
    public void setPrioritaet(String prioritaet) {
        this.prioritaet = prioritaet;
    }

    // Getter für status
    public String getStatus() {
        return status;
    }

    // Setter für status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter für recordingTime
    public LocalDateTime getRecordingTime() {
        return recordingTime;
    }

    // Setter für recordingTime
    public void setRecordingTime(LocalDateTime recordingTime) {
        this.recordingTime = recordingTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void assignPatient(Patient patient) {
        this.patient = patient;
    }
}

