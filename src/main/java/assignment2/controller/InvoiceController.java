package assignment2.controller;

import assignment2.model.Invoice;
import assignment2.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;


    @RequestMapping(path = "/invoices", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoice();
    }

    @RequestMapping(path = "/invoices", method = RequestMethod.POST)
    public long addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }
}
