package de.htwberlin.webtech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
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
    @Column(length = 2048)
    private String note;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<File> files = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private Set<ToDo> toDos = new HashSet<>();

    public Patient() {
    }

    public Patient(String name, String firstname) {
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

    //Calculate the age of the patient
    public int calculateAge() {
        LocalDate today = LocalDate.now();
        if (birthDate != null && birthDate.isAfter(today)) {
            throw new IllegalArgumentException("Geburtsdatum kann nicht in der Zukunft liegen");
        }

        int age = today.getYear() - birthDate.getYear();
        if (birthDate != null && (today.getMonthValue() < birthDate.getMonthValue() ||
                (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth()))) {
            age--;
        }
        return age;
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
        return Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(firstname, patient.firstname) &&
                Objects.equals(birthDate, patient.birthDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstname, birthDate);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

}
