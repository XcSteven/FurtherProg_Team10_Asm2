package assignment2.controller;

import assignment2.model.Booking;
import assignment2.service.BookingService;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    public Booking getABooking(@PathVariable Long id) {
        return bookingService.getABooking(id);
    }

    @RequestMapping(path = "/bookings", method = RequestMethod.POST)
    public Long addBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/bookings/{id}")
    public String updateBooking(@RequestBody Booking newBooking, @PathVariable Long id) {
        return bookingService.updateBooking(newBooking, id);
    }

    @DeleteMapping("/bookings/{id}")
    public String deleteBooking(@PathVariable Long id){
        return  bookingService.deleteABooking(id);
    }

    @GetMapping("/bookings/search/date/{date}")
    public List<Booking> searchBookingByDate(@PathVariable String date) {
        return bookingService.searchBookingByDate(date);
    }

    @GetMapping("/bookings/search/date-range/{start}/{end}")
    public List<Booking> searchBookingByDateRange(@PathVariable("start") String start,@PathVariable("end") String end ) {
        return bookingService.searchBookingByDateRange(start, end);
    }
}
