package ru.ashitok.lake.dto;

import ru.ashitok.lake.models.enums.Type;

import java.time.LocalDateTime;

public record RoomDTO (
    Type type,
    Double price,
    Boolean isAvailable,
    LocalDateTime createdAt
) {
}