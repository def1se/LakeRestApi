package ru.ashitok.lake.dto;

import ru.ashitok.lake.models.enums.Role;

import java.time.LocalDateTime;

public record UserDTO (
    String email,
    Role role,
    LocalDateTime createdAt
) {
}
