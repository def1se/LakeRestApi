package ru.ashitok.lake.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.ashitok.lake.models.Hotel;
import ru.ashitok.lake.models.User;

import java.time.LocalDateTime;

public record ReviewDTO (
    String text,
    Double rating,
    LocalDateTime createdAt
) {
}
