package ru.ashitok.lake.dto;

import org.mapstruct.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record HotelResponseDTO (
    String name,
    String address,
    UserDTO user,
    LocalDateTime createdAt,
    List<RoomDTO> rooms,
    List<ReviewDTO> reviews
) {
}
