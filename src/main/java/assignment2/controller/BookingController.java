package assignment2.controller;

import assignment2.model.Booking;
import assignment2.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @RequestMapping(path = "/bookings", method = RequestMethod.GET)
    public List<Booking> getAllBookings(){
        return bookingService.getAllBooking();
    }

    @RequestMapping(path = "/bookings/{id}", method = RequestMethod.GET)
    public Booking getABooking(@PathVariable long id) {
        return bookingService.getABooking(id);
    }

    @RequestMapping(path = "/bookings", method = RequestMethod.POST)
    public long addBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/bookings/{id}")
    public String updateBooking(@RequestBody Booking newBooking, @PathVariable long id) {
        return bookingService.updateBooking(newBooking, id);
    }

    @DeleteMapping("/bookings/{id}")
    public String deleteBooking(@PathVariable long id){
        return  bookingService.deleteABooking(id);
    }
}
