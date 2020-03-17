package ru.iopent.parking.dto.parking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FreeSlotsDto {
    private final Boolean freeSlotsAvailable;
}
