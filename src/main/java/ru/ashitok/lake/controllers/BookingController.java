package ru.ashitok.lake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ashitok.lake.dto.BookingCreateDTO;
import ru.ashitok.lake.dto.BookingResponseDTO;
import ru.ashitok.lake.services.BookingService;
import ru.ashitok.lake.util.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping()
    public List<BookingResponseDTO> getBookings() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public BookingResponseDTO getBooking(@PathVariable("id") int id) {
        return bookingService.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<BookingResponseDTO> getBookingsOfUser(@PathVariable("id") int id) {
        return bookingService.findByUserId(id);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> save(@RequestBody BookingCreateDTO bookingCreateDTO) {
        bookingService.save(bookingCreateDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<BookingErrorResponse> handleException(BookingNotFoundException e) {
        BookingErrorResponse bookingErrorResponse = new BookingErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(bookingErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserOrRoomNotFoundException e) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }
}
