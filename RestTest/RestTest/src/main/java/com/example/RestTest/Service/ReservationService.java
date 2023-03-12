package com.example.RestTest.Service;

import com.example.RestTest.DTO.Reservation;
import com.example.RestTest.Repository.ReservationRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository repository;

    public Reservation[] getAll(){
        List<Reservation> reservations = (List<Reservation>) repository.findAll();;
        Reservation[] output = new Reservation[reservations.size()];
        for(int i = 0; i < reservations.size(); i++){
            output[i] = reservations.get(i);
        }
        return output;
    }

    public Reservation[] findByName(String name){
        return repository.findByName(name);
    }

    public Reservation findById(Long id){
        Optional<Reservation> reservation = repository.findById(id);
        return reservation.orElse(null);
    }

    public Reservation findByIdAndEmail(String input){
        JSONObject in = new JSONObject(input);
        Long id = Long.parseLong(in.getString("id"));
        String email = in.getString("email");
        Optional<Reservation> res = repository.findByIdAndEmail(id, email);
        return res.orElse(null);
    }

    public String addReservation(String input){
        Reservation reservation = new Reservation();
        JSONObject in = new JSONObject(input);
        String name = in.getString("name");
        String email = in.getString("email");
        String number = in.getString("number");
        reservation.setName(name);
        reservation.setEmail(email);
        reservation.setNumber(number);
        repository.save(reservation);
        return "Reservation Added";
    }

    public String updateNumber(Long id, String input){
        Optional<Reservation> res = repository.findById(id);
        JSONObject in = new JSONObject(input);
        if(res.isPresent()){
            Reservation resGet = res.get();
            repository.delete(resGet);
            Reservation resUpdate = new Reservation(resGet.getId(), resGet.getName(),
                    resGet.getEmail(),resGet.getPhoneNumber(), in.getString("number"));
            repository.save(resUpdate);
            return "Reservation Updated";
        } else {
            return "Reservation not Found";
        }
    }

    public String deleteAll(){
        repository.deleteAll();
        return "All Reservations are deleted!";
    }

    public String deleteReservation(Long id){
        Optional<Reservation> res = repository.findById(id);
        if(res.isPresent()){
            repository.delete(res.get());
            return "Reservation Deleted";
        } else {
            return "Reservation not found";
        }

    }

}
