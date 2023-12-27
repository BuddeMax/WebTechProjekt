package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vitalSigns")
public class VitalSigns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bloodPressure;
    private Integer heartRate;
    private Double oxygenSaturation;
    private Double temperature;
    private LocalDateTime recordingTime;

    public VitalSigns() {
    }

    public VitalSigns(String bloodPressure, Integer heartRate, Double oxygenSaturation, Double temperature, LocalDateTime recordingTime) {
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.oxygenSaturation = oxygenSaturation;
        this.temperature = temperature;
        this.recordingTime = recordingTime;
    }


    public Long getVitalSignId() { return id; }
    public void setVitalSignId(Long id) { this.id = id; }

    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }

    public Integer getHeartRate() { return heartRate; }
    public void setHeartRate(Integer heartRate) { this.heartRate = heartRate; }

    public Double getOxygenSaturation() { return oxygenSaturation; }
    public void setOxygenSaturation(Double oxygenSaturation) { this.oxygenSaturation = oxygenSaturation; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public LocalDateTime getRecordingTime() { return recordingTime; }
    public void setRecordingTime(LocalDateTime recordingTime) { this.recordingTime = recordingTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VitalSigns)) return false;
        VitalSigns that = (VitalSigns) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bloodPressure, that.bloodPressure) &&
                Objects.equals(heartRate, that.heartRate) &&
                Objects.equals(oxygenSaturation, that.oxygenSaturation) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(recordingTime, that.recordingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bloodPressure, heartRate, oxygenSaturation, temperature, recordingTime);
    }

    @Override
    public String toString() {
        return "VitalSigns{" +
                "id=" + id +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", heartRate=" + heartRate +
                ", oxygenSaturation=" + oxygenSaturation +
                ", temperature=" + temperature +
                ", recordingTime=" + recordingTime +
                '}';
    }
}
