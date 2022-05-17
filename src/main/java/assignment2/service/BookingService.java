package assignment2.service;

import assignment2.model.Booking;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class BookingService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long saveBooking(Booking booking) {
        sessionFactory.getCurrentSession().save(booking);
        return booking.getId();
    }

    public List<Booking> getAllBooking() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Booking.class);
        return criteria.list();
    }

    public Booking getABooking(Long id) {
        return sessionFactory.getCurrentSession().get(Booking.class, id);
    }
    public String updateBooking(Booking newBooking, Long id) {
        List<Booking> bookingList = getAllBooking();
        for (Booking booking : bookingList) {
            if (booking.getId() == id) {
                sessionFactory.getCurrentSession().evict(booking);
                booking.setStartLocation(newBooking.getStartLocation());
                booking.setEndLocation(newBooking.getEndLocation());
                booking.setStartTime(newBooking.getStartTime());
                booking.setEndTime(newBooking.getEndTime());
                booking.setDistance(newBooking.getDistance());
                sessionFactory.getCurrentSession().update(booking);
                return "Updated booking with id " + id;
            }
        }
        return "Can't find booking with id " + id;
    }

    public String deleteABooking(Long id) {
        Booking booking = sessionFactory.getCurrentSession().get(Booking.class, id);
        if(booking != null) {
            sessionFactory.getCurrentSession().delete(booking);
            return "Deleted booking with id " + id;
        }

        return "Can't find booking with id " + id;
    }

    public List<Booking> searchBookingByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Booking> bookingList = getAllBooking();
        List<Booking> searchList = new ArrayList<>();
        for (Booking booking : bookingList) {
            if(booking.getDateCreated().format(formatter).toLowerCase().contains(date)) {
                searchList.add(booking);
            }
        }
        return searchList;
    }
}
