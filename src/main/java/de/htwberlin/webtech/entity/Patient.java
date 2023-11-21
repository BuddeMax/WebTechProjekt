package de.htwberlin.webtech.entity;

import de.htwberlin.webtech.*;
import jakarta.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstname;
    private int age;


    public Patient() {
    }

    public Patient(String name,String firstname, int age) {
        this.name = name;
        this.firstname = firstname;
        this.age = age;
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
                '}';
    }

}
