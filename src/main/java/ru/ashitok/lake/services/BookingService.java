package ru.ashitok.lake.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ashitok.lake.dto.BookingCreateDTO;
import ru.ashitok.lake.dto.BookingResponseDTO;
import ru.ashitok.lake.mapper.BookingMapper;
import ru.ashitok.lake.models.Booking;
import ru.ashitok.lake.models.Room;
import ru.ashitok.lake.models.User;
import ru.ashitok.lake.repositories.BookingRepository;
import ru.ashitok.lake.repositories.RoomRepository;
import ru.ashitok.lake.repositories.UserRepository;
import ru.ashitok.lake.util.BookingNotFoundException;
import ru.ashitok.lake.util.UserNotFoundException;
import ru.ashitok.lake.util.UserOrRoomNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, RoomRepository roomRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.bookingMapper = bookingMapper;
    }

    public List<BookingResponseDTO> findAll() {
        return bookingMapper.toDTOList(bookingRepository.findAll());
    }

    public BookingResponseDTO findById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.map(bookingMapper::toDTO).orElseThrow(() -> new BookingNotFoundException("Бронь не найдена"));
    }

    public List<BookingResponseDTO> findByUserId(int id) {
        if (userRepository.existsById(id)) {
            return bookingMapper.toDTOList(bookingRepository.findByUser_Id(id));
        } else {
            throw new UserNotFoundException("Пользователь с id " + id + " не найден");
        }
    }

    @Transactional
    public void save(BookingCreateDTO bookingCreateDTO) {
        if (userRepository.existsByEmail(bookingCreateDTO.userEmail()) && roomRepository.existsById(bookingCreateDTO.idOfRoom())) {
            User user = userRepository.findByEmail(bookingCreateDTO.userEmail());
            Optional<Room> room = roomRepository.findById(bookingCreateDTO.idOfRoom());
            Booking booking = bookingMapper.toEntity(bookingCreateDTO);
            booking.setUser(user);
            booking.setRoom(room.get());
            bookingRepository.save(booking);
        } else {
            throw new UserOrRoomNotFoundException("Неправильно введены данные");
        }
    }
}
