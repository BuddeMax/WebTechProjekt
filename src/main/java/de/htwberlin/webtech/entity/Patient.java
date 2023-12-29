package de.htwberlin.webtech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstname;
    private int age;// umändern zu birthdate
    private LocalDate birthDate;
    private String gender;
    private String note;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<File> files = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<ToDo> toDos = new HashSet<>();

    public Patient() {
    }

    public Patient(String name, String firstname, int age) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;// umändern zu birthdate
        this.birthDate = birthDate;
        this.gender = gender;
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

    public String getNote() {return note;}
    public void setNote(String note) {this.note = note;}

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Set<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(Set<ToDo> toDos) {
        this.toDos = toDos;
    }

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
                ", note='" + note + '\'' +
                '}';
    }

}
