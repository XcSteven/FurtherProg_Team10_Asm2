package assignment2.service;

import assignment2.model.Invoice;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class InvoiceService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long saveInvoice(Invoice invoice) {
        sessionFactory.getCurrentSession().save(invoice);
        return invoice.getId();
    }

    public List<Invoice> getAllInvoice() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
        return criteria.list();
    }

    public Invoice getAnInvoice(long id) {
        return sessionFactory.getCurrentSession().get(Invoice.class, id);
    }

    public String updateInvoice(Invoice newInvoice, long id) {
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

    public String deleteAnInvoice(long id) {
        Invoice invoice = sessionFactory.getCurrentSession().get(Invoice.class, id);
        if(invoice != null) {
            sessionFactory.getCurrentSession().delete(invoice);
            return "Deleted invoice with id " + id;
        }

        return "Can't find invoice with id " + id;
    }
}
