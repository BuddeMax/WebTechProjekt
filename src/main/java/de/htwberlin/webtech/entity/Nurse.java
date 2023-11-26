package de.htwberlin.webtech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user_nurse\"")
public class Nurse extends AbstractUser {
    private String nursingDepartment;


    public Nurse() {
    }

    public void setNursingDepartment(String nursingDepartment) { this.nursingDepartment = nursingDepartment; }

    public boolean canRequestDoctorVisit() {return true;}

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
        return "Nurse{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}
