package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column (name = "firstname")
    private String firstname;
    @Column (name = "lastname")
    private String lastname;
    @Column (name = "birthdate")
    private LocalDateTime birthdate;
    @Transient
    private Integer age;
    @Column(name = "gender")
    private String gender;

    public AbstractUser() {
    }

    public AbstractUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        if (birthdate != null) {
            LocalDate today = LocalDate.now();
            LocalDate birthLocalDate = birthdate.toLocalDate();
            return Period.between(birthLocalDate, today).getYears();
        }
        return null; // Oder eine Standard-Rückgabewert, wenn das Geburtsdatum nicht gesetzt ist
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Überarbeitete Methoden
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstname, lastname, birthdate, age, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractUser that = (AbstractUser) obj;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(age, that.age) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}


