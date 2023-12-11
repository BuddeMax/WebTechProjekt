package de.htwberlin.webtech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user_physician\"")
public class Physician extends AbstractUser {
    @Column(name = "specialty")
    private String specialty;

    public Physician() {
    }

    public Physician(String username, String password) {
        setUsername(username);
        setPassword(password);
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
                '}';
    }
}

