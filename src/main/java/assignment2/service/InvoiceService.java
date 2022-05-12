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

    public List<Invoice> getAllInvoice(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
        return criteria.list();
    }
}
