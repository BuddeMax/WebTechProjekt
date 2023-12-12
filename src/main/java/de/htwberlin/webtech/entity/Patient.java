package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String username;
    private String password;
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
    @JoinColumn(name = "doctorId")
    private AbstractUser responsiblePhysician;

    @ManyToOne
    @JoinColumn(name = "nurseId")
    private AbstractUser responsibleNurse;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VitalSigns> vitalSigns;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ToDo> toDos;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<File> files = new HashSet<>();

    private String note;

    public Patient() {
    }

    public Patient(String name,String firstname, int age) {
        this.password = password;
        this.username = username;
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
        this.vitalSigns = vitalSigns;
        this.files = files;
    }

    public Long getId() {
        return patientId;
    }
    public void setId(Long patientId) {
        this.patientId = patientId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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

    public Set<VitalSigns> getVitalSigns() {return vitalSigns;}
    public  VitalSigns getVitalSign(Long vitalSignId) {
        for (VitalSigns vitalSign : vitalSigns) {
            if (vitalSign.getVitalSignId().equals(vitalSignId)) {
                return vitalSign;
            }
        }
        return null;
    }
    public void addVitalSign(VitalSigns vitalSign) {this.vitalSigns.add(vitalSign);}
    public void removeVitalSign(VitalSigns vitalSign) {this.vitalSigns.remove(vitalSign);}
    public void setVitalSigns(Set<VitalSigns> vitalSigns) {this.vitalSigns = vitalSigns;}

    public Set<ToDo> getToDos() {return toDos;}
    public ToDo getToDo (Long toDoId) {
        for (ToDo toDo : toDos) {
            if (toDo.getToDoId().equals(toDoId)) {
                return toDo;
            }
        }
        return null;
    }
    public void setToDos(Set<ToDo> toDos) {this.toDos = toDos;}
    public void addToDo (ToDo toDo) {this.toDos.add(toDo);}
    public void removeToDo (ToDo toDo) {this.toDos.remove(toDo);}


    public Set<File> getFiles() {return files;}

    public File getFile(Long fileId) {
        for (File file : files) {
            if (file.getId().equals(fileId)) {
                return file;
            }
        }
        return null;
    }

    public void removeFile(File file) {
        this.files.remove(file);
    }
    public void setFiles(Set<File> files) {this.files = files;}

    public void addFile(File file) {
        this.files.add(file);
    }

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
                "id=" + patientId +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", bedId=" + (bed != null ? bed.getId() : null) +
                ", areaId=" + (area != null ? area.getAreaId() : null) +
                ", responsibleDoctorId=" + (responsiblePhysician != null ? responsiblePhysician.getId() : null) +
                ", responsibleNurseId=" + (responsibleNurse != null ? responsibleNurse.getId() : null) +
                ", vitalSigns=" + vitalSigns +
                ", note='" + note + '\'' +
                '}';
    }
}
