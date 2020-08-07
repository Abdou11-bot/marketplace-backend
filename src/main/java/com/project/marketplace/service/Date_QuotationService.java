package com.project.marketplace.service;

import com.project.marketplace.repository.Date_QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Date_QuotationService {
    private final Date_QuotationRepository date_quotationRepository;
//    private final QuotationService quotationService;
//    private final ProductService productService;

    public Date_QuotationService(Date_QuotationRepository date_quotationRepository, QuotationService quotationService, ProductService productService) {
        this.date_quotationRepository = date_quotationRepository;
//        this.quotationService = quotationService;
//        this.productService = productService;
////        this.initDB();
//        Date_Quotation d=this.date_quotationRepository.findAll().get(0);
//        System.out.println(d.getProduct().toString()+"    tzuagebhnsaqzd"+d.getQuotation().toString());
    }
//    private void initDB() {
//        Date_Quotation date_quotation = new Date_Quotation();
//        date_quotation.setDate(new Date());
//        date_quotation.setLocality("Fes");
//        date_quotation.setProduct(productService.getAllProducts().get(0));
//        date_quotation.setQuotation(quotationService.getAllQuotations().get(0));
//        this.addData_Quotation(date_quotation);
//    }
}
