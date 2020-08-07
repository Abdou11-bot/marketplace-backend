package com.project.marketplace.rest;

import com.project.marketplace.service.Date_QuotationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/date_quotation")
public class Data_QuotationController {
    private final Date_QuotationService  date_quotationService;

    public Data_QuotationController(Date_QuotationService date_quotationService) {
        this.date_quotationService = date_quotationService;
    }

}
