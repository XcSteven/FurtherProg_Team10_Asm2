package assignment2.service;

import assignment2.model.Booking;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
@Transactional
@Service
public class BookingService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long saveBooking(Booking booking) {
        sessionFactory.getCurrentSession().save(booking);
        return booking.getId();
    }

    public List<Booking> getAllBooking() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Booking.class);
        return criteria.list();
    }

    public Booking getABooking(long id) {
        return sessionFactory.getCurrentSession().get(Booking.class, id);
    }
    public String updateBooking(Booking newBooking, long id) {
        List<Booking> bookingList = getAllBooking();
        for (Booking booking : bookingList) {
            if (booking.getId() == id){
                sessionFactory.getCurrentSession().evict(booking);
                booking.setStartLocation(newBooking.getStartLocation());
                booking.setEndLocation(newBooking.getEndLocation());
                booking.setPickup(newBooking.getPickup());
                booking.setDropoff(newBooking.getDropoff());
                booking.setDistance(newBooking.getDistance());
                sessionFactory.getCurrentSession().update(booking);
                return "Updated booking with id " + id;
            }
        }
        return "Can't find booking with id " + id;
    }

    public String deleteABooking(long id){
        Booking booking = sessionFactory.getCurrentSession().get(Booking.class, id);
        if(booking != null){
            sessionFactory.getCurrentSession().delete(booking);
            return "Deleted booking with id " + id;
        }

        return "Can't find booking with id " + id;
    }
}
