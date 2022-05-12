package assignment2.service;

import assignment2.model.Booking;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Booking> getAllBooking(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Booking.class);
        return criteria.list();
    }
}
