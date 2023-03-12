package com.example.RestTest.Controller;

import com.example.RestTest.DTO.Reservation;
import com.example.RestTest.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "/getAll", produces = APPLICATION_JSON_VALUE)
    public Reservation[] get(){
        return reservationService.getAll();
    }

    @PostMapping(value = "/findById/{id}", produces = APPLICATION_JSON_VALUE)
    public Reservation findById(@PathVariable Long id){
        return reservationService.findById(id);
    }

    @PostMapping(value = "/findByName/{name}", produces = APPLICATION_JSON_VALUE)
    public Reservation[] findByName(@PathVariable String name){
        return reservationService.findByName(name);
    }

    @PostMapping(value = "findByIdAndEmail" , produces = APPLICATION_JSON_VALUE)
    public Reservation findByIdAndEmail(@RequestBody String input){
        return reservationService.findByIdAndEmail(input);
    }
    @PostMapping(value = "/add", produces = APPLICATION_JSON_VALUE)
    public String addReservation(@RequestBody String input){
        return reservationService.addReservation(input);
    }

    @PutMapping(value = "/update/{id}", produces = APPLICATION_JSON_VALUE)
    public String updateNumber(@PathVariable Long id, @RequestBody String input){
        return reservationService.updateNumber(id, input);
    }

    @DeleteMapping(value = "/delete/{id}", produces = APPLICATION_JSON_VALUE)
    public String deleteReservation(@PathVariable Long id){
        return reservationService.deleteReservation(id);
    }

    @DeleteMapping(value = "/deleteAll", produces =  APPLICATION_JSON_VALUE)
    public String deleteAllReservations(){
        return reservationService.deleteAll();
    }
}
