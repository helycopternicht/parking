package ru.iopent.parking.dto.sensor;

public class SensorDto {
    private final Integer number;
    private final Boolean isBusy;

    public SensorDto(Integer number, Boolean isBusy) {
        this.number = number;
        this.isBusy = isBusy;
    }

    public Integer getNumber() {
        return number;
    }

    public Boolean getBusy() {
        return isBusy;
    }
}
