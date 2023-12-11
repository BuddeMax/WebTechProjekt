package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Persistent;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Patient extends AbstractUser{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientId")
    private Long id;

    @OneToOne
    @JoinColumn(name = "bedId")
    public Bed bed;

    @OneToOne
    @JoinColumn(name = "areaId")
    private Area area;

    @OneToOne
    @JoinColumn(name = "doctorId")
    private Physician responsiblePhysician;

    @OneToOne
    @JoinColumn(name = "nurseId")
    private Nurse responsibleNurse;

    @OneToMany
    @JoinColumn(name = "vitalSignsId")
    private List<VitalSigns> vitalSigns;

    @Column(name = "note")
    private String note;

    @OneToMany
    @JoinColumn(name = "fileId")
    private List<File> files;

    public Patient() {
    }

    public Patient(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Bed getBed() {return bed;}
    public void setBed(Bed bed) {this.bed = bed;}

    public Area getArea() {return area;}
    public void setArea(Area area) {this.area = area;}

    public Physician getResponsiblePhysician() {
        return (Physician) responsiblePhysician;
    }

    public void setResponsiblePhysician(Physician responsiblePhysician) {
        this.responsiblePhysician = responsiblePhysician;
    }

    public Nurse getResponsibleNurse() {
        return (Nurse) responsibleNurse;
    }

    public void setResponsibleNurse(Nurse responsibleNurse) {
        this.responsibleNurse = responsibleNurse;
    }

    public List<VitalSigns> getVitalSigns() {return vitalSigns; }
    public void setVitalSigns(List<VitalSigns> vitalSigns) {this.vitalSigns = vitalSigns;}

    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        if (!super.equals(o)) return false; // Check fields from the superclass

        Patient patient = (Patient) o;

        if (!Objects.equals(id, patient.id)) return false;
        if (!Objects.equals(bed, patient.bed)) return false;
        if (!Objects.equals(area, patient.area)) return false;
        if (!Objects.equals(responsiblePhysician, patient.responsiblePhysician)) return false;
        if (!Objects.equals(responsibleNurse, patient.responsibleNurse)) return false;
        return Objects.equals(vitalSigns, patient.vitalSigns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, bed, area, responsiblePhysician, responsibleNurse, vitalSigns);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", bed=" + (bed != null ? bed.getId() : null) +
                ", area=" + (area != null ? area.getAreaId() : null) +
                ", responsiblePhysician=" + (responsiblePhysician != null ? responsiblePhysician.getId() : null) +
                ", responsibleNurse=" + (responsibleNurse != null ? responsibleNurse.getId() : null) +
                ", vitalSigns=" + vitalSigns +
                ", note='" + note + '\'' +
                "} " + super.toString(); // Include fields from the superclass
    }
}
