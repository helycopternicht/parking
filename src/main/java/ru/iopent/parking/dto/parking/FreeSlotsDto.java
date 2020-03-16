package ru.iopent.parking.dto.parking;

public class FreeSlotsDto {
    private Boolean freeSlotsAvailable;

    public FreeSlotsDto(Boolean isFreeSlotsAvailable) {
        this.freeSlotsAvailable = isFreeSlotsAvailable;
    }

    public Boolean getFreeSlotsAvailable() {
        return freeSlotsAvailable;
    }
}
