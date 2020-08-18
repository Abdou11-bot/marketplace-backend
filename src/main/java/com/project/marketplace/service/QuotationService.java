package com.project.marketplace.service;

import com.project.marketplace.entity.Medecin;
import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Quotation;
import com.project.marketplace.repository.QuotationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuotationService {
    private final QuotationRepository quotationRepository;
    private final ProductService productService;
    private final ProviderService providerService;
    private final MedecinService medecinService;

    public QuotationService(QuotationRepository quotationRepository, ProductService productService, ProviderService providerService, MedecinService medecinService) {
        this.quotationRepository = quotationRepository;
        this.productService = productService;
//        this.initDB();
        this.providerService = providerService;
        this.medecinService = medecinService;
    }
//    private void initDB() {
//        Quotation quotation = new Quotation();
//        quotation.setEmail("Abdou@gmail.com");
//        quotation.setAddress("CIN1");
//        quotation.setFirstname("Laouali");
//        quotation.setLastname("Mahaboubou");
//        quotation.setProduct(productService.getAllProducts().get(0));
//        this.addQuotation(quotation);
//    }
    public Quotation addQuotation(Quotation quotation) {
        return this.quotationRepository.save(quotation);
    }


    public List<Quotation> getAllQuotations(){ return  this.quotationRepository.findAll();}
    public  Quotation getQuotation(long id){ return  this.quotationRepository.findById(id).orElseThrow();}
    public  List<Quotation> getQuotationOfProduct(long id){ return  this.quotationRepository.findAllByProductEquals(this.productService.getProduct(id));}

    public List<Quotation> getAllQuotationstoProviders(String login) {
        List<Product> products = this.providerService.getOwnedProducts(this.providerService.getProviderByEmail(login).getId());
        List<Quotation> quotations = new ArrayList<>();
        for(Product product : products){
            quotations.addAll(this.getQuotationOfProduct(product.getId()));
        }
        return  quotations;
    }
    public List<Quotation> getQuotationRequestedBy(String login) {
        Medecin medecin = this.medecinService.getMedecin(login);
        List<Quotation> quotations = new ArrayList<>();
        quotations.addAll(this.quotationRepository.findAllByMedecinEquals(medecin));
        return  quotations;
    }
    public boolean DeleteQuotation(long id){
        this.quotationRepository.deleteById(id);
        return true;
    }
}
