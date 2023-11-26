package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstname;
    private int age;// umändern zu birthdate
    private LocalDate birthDate;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "bedId")
    private Bed bed;

    @ManyToOne
    @JoinColumn(name = "areaId")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "responsibleDoctorId")
    private AbstractUser responsiblePhysician;

    @ManyToOne
    @JoinColumn(name = "responsibleNurseId")
    private AbstractUser responsibleNurse;

    @ManyToOne
    @JoinColumn(name = "vitalSignsId")
    private VitalSigns vitalSigns;

    private String note;

    public Patient() {
    }

    public Patient(String name,String firstname, int age) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;// umändern zu birthdate
        this.birthDate = birthDate;
        this.gender = gender;
        this.bed = bed;
        this.area = area;
        this.responsiblePhysician = responsiblePhysician;
        this.responsibleNurse = responsibleNurse;
        this.note = note;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {return firstname;}
    public void setFirstname(String firstname){ this.firstname = firstname;}

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public Bed getBed() {return bed;}
    public void setBed(Bed bed) {this.bed = bed;}

    public Area getArea() {return area;}
    public void setArea(Area area) {this.area = area;}

    public AbstractUser getResponsiblePhysician() {return responsiblePhysician;}
    public void setResponsiblePhysician(AbstractUser responsiblePhysician) {this.responsiblePhysician = responsiblePhysician;}

    public AbstractUser getResponsibleNurse() {return responsibleNurse;}
    public void setResponsibleNurse(AbstractUser responsibleNurse) {this.responsibleNurse = responsibleNurse;}

    public VitalSigns getVitalSigns() {return vitalSigns;}
    public void setVitalSigns(VitalSigns vitalSigns) {this.vitalSigns = vitalSigns;}

    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        if (getAge() != patient.getAge()) return false;
        if (getId() != null ? !getId().equals(patient.getId()) : patient.getId() != null) return false;
        return getName() != null ? getName().equals(patient.getName()) : patient.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", bedId=" + (bed != null ? bed.getId() : null) +
                ", areaId=" + (area != null ? area.getAreaId() : null) +
                ", responsibleDoctorId=" + (responsiblePhysician != null ? responsiblePhysician.getId() : null) +
                ", responsibleNurseId=" + (responsibleNurse != null ? responsibleNurse.getId() : null) +
                ", vitalSignsId=" + (vitalSigns != null ? vitalSigns.getId() : null) +
                ", note='" + note + '\'' +
                '}';
    }
}
