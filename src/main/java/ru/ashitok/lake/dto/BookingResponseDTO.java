package ru.ashitok.lake.dto;

import ru.ashitok.lake.models.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookingResponseDTO (
    LocalDate dateIn,
    LocalDate dateOut,
    Status status,
    UserDTO user,
    RoomDTO room,
    LocalDateTime createdAt
) {
}