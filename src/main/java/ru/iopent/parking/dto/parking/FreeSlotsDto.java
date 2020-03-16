package ru.iopent.parking.dto.parking;

public class FreeSlotsDto {
    private Boolean isFreeSlotsAvailable;

    public FreeSlotsDto(Boolean isFreeSlotsAvailable) {
        this.isFreeSlotsAvailable = isFreeSlotsAvailable;
    }

    public Boolean getFreeSlotsAvailable() {
        return isFreeSlotsAvailable;
    }
}
