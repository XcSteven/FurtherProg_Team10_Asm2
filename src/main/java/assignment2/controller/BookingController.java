package assignment2.controller;

import assignment2.model.Booking;
import assignment2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @RequestMapping(path = "/bookings", method = RequestMethod.GET)
    public List<Booking> getAllBookings(){
        return bookingService.getAllBooking();
    }

    @RequestMapping(path = "/cars", method = RequestMethod.POST)
    public long addBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }
}
