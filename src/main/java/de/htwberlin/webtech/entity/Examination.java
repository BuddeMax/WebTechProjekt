package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    private String typeOfExamination;
    private LocalDateTime appointmentDateTime;

    @ManyToOne
    @JoinColumn(name = "responsibleStaffId")
    private AbstractUser responsibleStaff; // Optional

    private String specificInstructions; // Optional

    public Examination() {
    }

    public Examination(Patient patient, String typeOfExamination, LocalDateTime appointmentDateTime, AbstractUser responsibleStaff, String specificInstructions) {
        this.patient = patient;
        this.typeOfExamination = typeOfExamination;
        this.appointmentDateTime = appointmentDateTime;
        this.responsibleStaff = responsibleStaff;
        this.specificInstructions = specificInstructions;
    }

    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public String getTypeOfExamination() { return typeOfExamination; }
    public void setTypeOfExamination(String typeOfExamination) { this.typeOfExamination = typeOfExamination; }

    public LocalDateTime getAppointmentDateTime() { return appointmentDateTime; }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) { this.appointmentDateTime = appointmentDateTime; }

    public AbstractUser getResponsibleStaff() { return responsibleStaff; }
    public void setResponsibleStaff(AbstractUser responsibleStaff) { this.responsibleStaff = responsibleStaff; }

    public String getSpecificInstructions() { return specificInstructions; }
    public void setSpecificInstructions(String specificInstructions) { this.specificInstructions = specificInstructions; }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Examination)) return false;
        Examination that = (Examination) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(typeOfExamination, that.typeOfExamination) &&
                Objects.equals(appointmentDateTime, that.appointmentDateTime) &&
                Objects.equals(responsibleStaff, that.responsibleStaff) &&
                Objects.equals(specificInstructions, that.specificInstructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, typeOfExamination, appointmentDateTime, responsibleStaff, specificInstructions);
    }

    @Override
    public String toString() {
        return "Examination{" +
                "id=" + id +
                ", patientId=" + (patient != null ? patient.getId() : null) +
                ", typeOfExamination='" + typeOfExamination + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", responsibleStaffId=" + (responsibleStaff != null ? responsibleStaff.getId() : null) +
                ", specificInstructions='" + specificInstructions + '\'' +
                '}';
    }
}

