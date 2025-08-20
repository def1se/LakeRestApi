package ru.ashitok.lake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ashitok.lake.dto.HotelAddDTO;
import ru.ashitok.lake.dto.HotelResponseDTO;
import ru.ashitok.lake.services.HotelService;
import ru.ashitok.lake.util.HotelErrorResponse;
import ru.ashitok.lake.util.HotelNotFoundException;
import ru.ashitok.lake.util.UserErrorResponse;
import ru.ashitok.lake.util.UserNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping()
    public List<HotelResponseDTO> searchHotels() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public HotelResponseDTO searchHotel(@PathVariable("id") int id) {
        return hotelService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addHotel(@RequestBody HotelAddDTO hotelDTO) {
        hotelService.save(hotelDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<HotelErrorResponse> handleException(HotelNotFoundException e) {
        HotelErrorResponse hotelErrorResponse = new HotelErrorResponse(
            e.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(hotelErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e) {
        UserErrorResponse userErrorResponse = new UserErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(userErrorResponse, HttpStatus.NOT_FOUND);
    }
}
