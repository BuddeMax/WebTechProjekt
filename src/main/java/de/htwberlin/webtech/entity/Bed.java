package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bedId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "areaId")
    private Area area;

    @Column(name = "occupancyStatus")
    private boolean occupancyStatus;

    @OneToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    public Bed() {
    }

    public Bed(Area area, boolean occupancyStatus, Patient patient) {
        this.area = area;
        this.occupancyStatus = occupancyStatus;
        this.patient = patient;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Area getArea() { return area; }
    public void setArea(Area area) { this.area = area; }

    public boolean getOccupancyStatus() { return occupancyStatus; }
    public void setOccupancyStatus(boolean occupancyStatus) { this.occupancyStatus = occupancyStatus; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bed)) return false;
        Bed bed = (Bed) o;
        return Objects.equals(id, bed.id) &&
                Objects.equals(area, bed.area) &&
                Objects.equals(occupancyStatus, bed.occupancyStatus) &&
                Objects.equals(patient, bed.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, occupancyStatus, patient);
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", areaId=" + (area != null ? area.getAreaId() : null) +
                ", occupancyStatus='" + occupancyStatus + '\'' +
                ", patientId=" + (patient != null ? patient.getId() : null) +
                '}';
    }
}
