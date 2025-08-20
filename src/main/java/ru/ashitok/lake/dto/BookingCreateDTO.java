package ru.ashitok.lake.dto;

import ru.ashitok.lake.models.enums.Status;
import ru.ashitok.lake.models.enums.Type;

import java.time.LocalDate;

public record BookingCreateDTO (
    LocalDate dateIn,
    LocalDate dateOut,
    Status status,
    String userEmail,
    Integer idOfRoom
) {
}
