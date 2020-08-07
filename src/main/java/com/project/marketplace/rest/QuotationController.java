package com.project.marketplace.rest;


import com.google.gson.Gson;
import com.project.marketplace.entity.Complaint;
import com.project.marketplace.entity.Quotation;
import com.project.marketplace.service.QuotationService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/quotation")
public class QuotationController {
    private final QuotationService quotationService;

    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }
    @PostMapping("/add")
    public Quotation addQuotation(@RequestParam("quotation") String message){
        Quotation quotation = new Gson().fromJson(message, Quotation.class);
        quotation.setDate(new Date());
        return this.quotationService.addQuotation(quotation);
    }

    @GetMapping("getAll")
    public List<Quotation> getAllQuotations() {
        return this.quotationService.getAllQuotations();
    }

    @GetMapping("/traiter/{id}")
    public Quotation traiter(@PathVariable("id") long id){
        Quotation quotation = this.quotationService.getQuotation(id);
        quotation.setTraiter(true);
        return this.quotationService.addQuotation(quotation);
    }

    @GetMapping("getalltoprovider/{login}")
    public List<Quotation> getalltoprovides(@PathVariable("login") String login) {
        return this.quotationService.getAllQuotationstoProviders(login);
    }

    @GetMapping("get/{id}")
    public Quotation getQuotation(@PathVariable("id") long id) {
        return this.quotationService.getQuotation(id);
    }

    @GetMapping("getAllOf/{id}")
    public List<Quotation> getQuotationsOfProduct(@PathVariable("id") long id) {
        return this.quotationService.getQuotationOfProduct(id);
    }

}
