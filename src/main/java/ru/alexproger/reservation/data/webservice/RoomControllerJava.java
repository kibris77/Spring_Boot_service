package ru.alexproger.reservation.data.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alexproger.reservation.data.entity.Room;
import ru.alexproger.reservation.data.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomControllerJava {
    @Autowired
    private RoomRepository repository;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    List<Room> findAll(@RequestParam(required = false)String roomNumber) {
        List<Room> rooms = new ArrayList<>();
        if (null == roomNumber) {
            Iterable<Room> results = repository.findAll();
            results.forEach(room -> rooms.add(room));
        } else {
            Room room = repository.findByNumber(roomNumber);
            if (null != room) {
                rooms.add(room);
            }
        }
        return rooms;
    }
}
