package ru.iopent.parking.dto.sensor;

public class SensorDto {
    private Integer number;
    private Boolean isBusy;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }
}
