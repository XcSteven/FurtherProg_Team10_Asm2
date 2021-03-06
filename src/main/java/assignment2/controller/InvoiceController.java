package assignment2.controller;

import assignment2.model.Invoice;
import assignment2.model.Invoice;
import assignment2.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;


    @RequestMapping(path = "/invoices", method = RequestMethod.GET)
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoice();
    }

    @RequestMapping(path = "/invoices/{id}", method = RequestMethod.GET)
    public Invoice getAnInvoice(@PathVariable Long id) {
        return invoiceService.getAnInvoice(id);
    }

    @RequestMapping(path = "/invoices", method = RequestMethod.POST)
    public Long addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @PutMapping("/invoices/{id}")
    public String updateInvoice(@RequestBody Invoice newInvoice, @PathVariable Long id) {
        return invoiceService.updateInvoice(newInvoice, id);
    }

    @DeleteMapping("/invoices/{id}")
    public String deleteInvoice(@PathVariable Long id){
        return invoiceService.deleteAnInvoice(id);
    }

    @GetMapping("/invoices/search/date/{date}")
    public List<Invoice> searchInvoiceByDate(@PathVariable String date) {
        return invoiceService.searchInvoiceByDate(date);
    }

    @GetMapping("/invoices/search/date-range/{start}/{end}")
    public List<Invoice> searchInvoiceByDateRange(@PathVariable("start") String start, @PathVariable("end") String end ) {
        return invoiceService.searchInvoiceByDateRange(start, end);
    }
}
