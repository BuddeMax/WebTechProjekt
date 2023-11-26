package de.htwberlin.webtech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user_physician\"")
public class Physician extends AbstractUser {
    private String specialty;

    public Physician() {
    }

    public Physician(String username, String password, String role, String specialty) {
        super(username, password, role);
        this.specialty = specialty;
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public boolean canWriteMedicalOrder() {return true;}

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Physician{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}

