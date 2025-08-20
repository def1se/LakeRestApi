package ru.ashitok.lake.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.ashitok.lake.dto.HotelAddDTO;
import ru.ashitok.lake.dto.HotelResponseDTO;
import ru.ashitok.lake.dto.UserDTO;
import ru.ashitok.lake.models.Hotel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    @Mapping(source = "userEmail", target = "user.email")
    Hotel toEntity(HotelAddDTO hotelDTO);

    HotelResponseDTO toDTO(Hotel hotel);

    List<HotelResponseDTO> toDTOList(List<Hotel> hotels);
}
