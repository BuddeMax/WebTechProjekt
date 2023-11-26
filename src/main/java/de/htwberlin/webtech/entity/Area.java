package de.htwberlin.webtech.entity;

import jakarta.persistence.*;

@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;
    private String name;
    private String bed;
    private int capacity;

    public Area() {
    }

    public Area(String name, String bed, int capacity) {
        this.name = name;
        this.bed = bed;
        this.capacity = capacity;
    }

    public Long getAreaId() { return areaId; }
    public void setAreaId(Long id) { this.areaId = areaId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBed() { return bed; }
    public void setBed(String bed) { this.bed = bed; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return getCapacity() == area.getCapacity() &&
                getAreaId() != null ? getAreaId().equals(area.getAreaId()) : area.getAreaId() == null &&
                getName() != null ? getName().equals(area.getName()) : area.getName() == null &&
                getBed() != null ? getBed().equals(area.getBed()) : area.getBed() == null;
    }

    @Override
    public int hashCode() {
        int result = getAreaId() != null ? getAreaId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getBed() != null ? getBed().hashCode() : 0);
        result = 31 * result + getCapacity();
        return result;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + areaId +
                ", name='" + name + '\'' +
                ", bed='" + bed + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

