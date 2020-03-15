package ru.iopent.parking.dto;

public class ParkingDto {
    private Integer id;
    private String description;
    private Integer capacity;
    private Integer currentFullness;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCurrentFullness() {
        return currentFullness;
    }

    public void setCurrentFullness(Integer currentFullness) {
        this.currentFullness = currentFullness;
    }
}
