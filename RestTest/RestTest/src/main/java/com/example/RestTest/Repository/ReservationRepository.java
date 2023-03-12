package com.example.RestTest.Repository;

import com.example.RestTest.DTO.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Reservation[] findByName(String name);
    Optional<Reservation> findByIdAndEmail(Long id, String email);
}
