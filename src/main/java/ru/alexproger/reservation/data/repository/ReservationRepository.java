package ru.alexproger.reservation.data.repository;

import org.springframework.data.repository.CrudRepository;
import ru.alexproger.reservation.data.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByDate(Date date);
}
