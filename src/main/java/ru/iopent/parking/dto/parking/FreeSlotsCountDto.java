package ru.iopent.parking.dto.parking;

public class FreeSlotsCountDto {
    private final Integer freeSlotsCount;

    public FreeSlotsCountDto(Integer freeSlotsCount) {
        this.freeSlotsCount = freeSlotsCount;
    }

    public Integer getFreeSlotsCount() {
        return freeSlotsCount;
    }
}
