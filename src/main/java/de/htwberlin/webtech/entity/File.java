package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    private String fileName;
    private String filePath;//DB zum Datn speichern für Laborergebnisse usw.
    private LocalDateTime uploadDate;
    private String description;//optional

    public File() {
    }

    public File(Patient patient, String fileName, String filePath, LocalDateTime uploadDate, String description) {
        this.patient = patient;
        this.fileName = fileName;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public LocalDateTime getUploadDate() { return uploadDate; }
    public void setUploadDate(LocalDateTime uploadDate) { this.uploadDate = uploadDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return Objects.equals(id, file.id) &&
                Objects.equals(patient, file.patient) &&
                Objects.equals(fileName, file.fileName) &&
                Objects.equals(filePath, file.filePath) &&
                Objects.equals(uploadDate, file.uploadDate) &&
                Objects.equals(description, file.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, fileName, filePath, uploadDate, description);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", patientId=" + (patient != null ? patient.getId() : null) +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", uploadDate=" + uploadDate +
                ", description='" + description + '\'' +
                '}';
    }
}
