package ru.ashitok.lake.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ashitok.lake.dto.HotelAddDTO;
import ru.ashitok.lake.dto.HotelResponseDTO;
import ru.ashitok.lake.mapper.HotelMapper;
import ru.ashitok.lake.models.Hotel;
import ru.ashitok.lake.models.User;
import ru.ashitok.lake.repositories.HotelRepository;
import ru.ashitok.lake.repositories.UserRepository;
import ru.ashitok.lake.util.HotelNotFoundException;
import ru.ashitok.lake.util.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class HotelService {
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;
    private final HotelMapper hotelMapper;

    @Autowired
    public HotelService(HotelRepository hotelRepository, UserRepository userRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
        this.hotelMapper = hotelMapper;
    }

    public List<HotelResponseDTO> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotelMapper.toDTOList(hotels);
    }

    public HotelResponseDTO findById(int id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.map(hotelMapper::toDTO).orElseThrow(() -> new HotelNotFoundException("Отель не найден"));
    }

    @Transactional
    public void save(HotelAddDTO hotelDTO) {
        if (userRepository.existsByEmail(hotelDTO.userEmail())) {
            User user = userRepository.findByEmail(hotelDTO.userEmail());
            Hotel hotel = hotelMapper.toEntity(hotelDTO);
            hotel.setUser(user);
            hotelRepository.save(hotel);
        } else {
            throw new UserNotFoundException("Пользователь с email " + hotelDTO.userEmail() + " не найден");
        }
    }
}
