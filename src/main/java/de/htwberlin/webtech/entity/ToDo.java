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
    @Column(name = "toDoId")
    private Long toDoId;
    @Column(name = "beschreibung")
    private String beschreibung;
    @Column(name = "prioritaet")
    private String prioritaet;
    @Column(name = "status")
    private String status;
    @Column(name = "recordingTime")
    private LocalDateTime recordingTime;

    @ManyToOne
    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "patientId")
    private Patient patient;

    // Getter für toDoId
    public Long getToDoId() {
        return toDoId;
    }

    // Setter für toDoId
    public void setToDoId(Long toDoId) {
        this.toDoId = toDoId;
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
}

