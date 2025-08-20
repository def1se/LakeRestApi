package ru.ashitok.lake.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.ashitok.lake.dto.BookingCreateDTO;
import ru.ashitok.lake.dto.BookingResponseDTO;
import ru.ashitok.lake.models.Booking;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mappings({
        @Mapping(source = "userEmail", target = "user.email"),
        @Mapping(source = "idOfRoom", target = "room.id")
    })
    Booking toEntity(BookingCreateDTO bookingCreateDTO);

    BookingResponseDTO toDTO(Booking booking);

    List<BookingResponseDTO> toDTOList(List<Booking> bookings);
}
