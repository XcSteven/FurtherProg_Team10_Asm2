package assignment2.service;

import assignment2.model.Invoice;
import assignment2.model.Invoice;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class InvoiceService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long saveInvoice(Invoice invoice) {
        sessionFactory.getCurrentSession().save(invoice);
        return invoice.getId();
    }

    public List<Invoice> getAllInvoice() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
        return criteria.list();
    }

    public Invoice getAnInvoice(Long id) {
        return sessionFactory.getCurrentSession().get(Invoice.class, id);
    }

    public String updateInvoice(Invoice newInvoice, Long id) {
        List<Invoice> invoiceList = getAllInvoice();
        for (Invoice invoice : invoiceList) {
            if (invoice.getId() == id) {
                sessionFactory.getCurrentSession().evict(invoice);
                invoice.setTotalCharge(newInvoice.getTotalCharge());
                sessionFactory.getCurrentSession().update(invoice);
                return "Updated invoice with id " + id;
            }
        }
        return "Can't find invoice with id " + id;
    }

    public String deleteAnInvoice(Long id) {
        Invoice invoice = sessionFactory.getCurrentSession().get(Invoice.class, id);
        if(invoice != null) {
            sessionFactory.getCurrentSession().delete(invoice);
            return "Deleted invoice with id " + id;
        }

        return "Can't find invoice with id " + id;
    }

    public List<Invoice> searchInvoiceByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Invoice> invoiceList = getAllInvoice();
        List<Invoice> searchList = new ArrayList<>();
        for (Invoice invoice : invoiceList) {
            if(invoice.getDateCreated().format(formatter).toLowerCase().contains(date)) {
                searchList.add(invoice);
            }
        }
        return searchList;
    }

    public List<Invoice> searchInvoiceByDateRange (String start, String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startTimeLocal = LocalDate.parse(start, formatter);
        LocalDate endTimeLocal = LocalDate.parse(end, formatter);

        ZonedDateTime startTime = startTimeLocal.atStartOfDay(ZoneId.systemDefault());
        ZonedDateTime endTime = endTimeLocal.atStartOfDay(ZoneId.systemDefault());

        List<Invoice> displayList = new ArrayList<>();
        for (Invoice booking : getAllInvoice()){
            ZonedDateTime createdDate = booking.getDateCreated();
            if(!(createdDate.isBefore(startTime) || createdDate.isAfter(endTime))){
                displayList.add(booking);
            }
        }
        return displayList;
    }
}
