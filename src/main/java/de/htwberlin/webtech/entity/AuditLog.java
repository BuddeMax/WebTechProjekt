package de.htwberlin.webtech.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AbstractUser abstractUser;

    private String action;
    private String changedData;
    private LocalDateTime timestamp;

    public AuditLog() {
    }

    public AuditLog(AbstractUser abstractUser, String action, String changedData, LocalDateTime timestamp) {
        this.abstractUser = abstractUser;
        this.action = action;
        this.changedData = changedData;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AbstractUser getUser() { return abstractUser; }
    public void setUser(AbstractUser abstractUser) { this.abstractUser = abstractUser; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getChangedData() { return changedData; }
    public void setChangedData(String changedData) { this.changedData = changedData; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditLog)) return false;
        AuditLog auditLog = (AuditLog) o;
        return Objects.equals(id, auditLog.id) &&
                Objects.equals(abstractUser, auditLog.abstractUser) &&
                Objects.equals(action, auditLog.action) &&
                Objects.equals(changedData, auditLog.changedData) &&
                Objects.equals(timestamp, auditLog.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abstractUser, action, changedData, timestamp);
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", userId=" + (abstractUser != null ? abstractUser.getId() : null) +
                ", action='" + action + '\'' +
                ", changedData='" + changedData + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

