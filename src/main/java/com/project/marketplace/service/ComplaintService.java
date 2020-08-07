package com.project.marketplace.service;

import com.project.marketplace.entity.Complaint;
import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComplaintService {
    private final ComplaintRepository complaintRepository;
    private final ProductService productService;
    private final ProviderService providerService;

    public ComplaintService(ComplaintRepository complaintRepository, ProductService productService, ProviderService providerService) {
        this.complaintRepository = complaintRepository;
        this.productService = productService;
//        this.initDB();
        this.providerService = providerService;
    }
//    private void initDB() {
//        Complaint complaint = new Complaint();
//        complaint.setEmail("Abdou@gmail.com");
//        complaint.setName("CIN1");
//        complaint.setMessage("Laouali");
//        complaint.setObjet("Mahaboubou");
//        complaint.setProduct(productService.getAllProducts().get(0));
//        this.addComplaint(complaint);
//    }

    public  List<Complaint> getAllComplaints(){ return  this.complaintRepository.findAll();}
    public  List<Complaint> getOwnedComplaint(String login){
        List<Product> products = new ArrayList<>();
        Provider provider = this.providerService.getProviderByEmail(login);
        products =this.productService.getResearchResult(provider.getId()+"","provider");
        List<Complaint> complaints =new ArrayList<>();
        for (Product product:products) {
            complaints.addAll(this.complaintRepository.findAllByProductEquals(product));
        }
        Collections.sort(complaints, new Comparator<Complaint>() {
            @Override
            public int compare(Complaint o1, Complaint o2)
            {
                return (o1.getId() < o2.getId() ? -1 :
                        (o1.getId() == o2.getId() ? 0 : 1));
            }
        });
        return complaints;
    }
    public  Complaint getComplaint(long id){ return  this.complaintRepository.findById(id).orElseThrow();}
    public  List<Complaint> getComplaintOfProduct(long id){ return  this.complaintRepository.findAllByProductEquals(this.productService.getProduct(id));}
    public Complaint addComplaint(Complaint complaint) {
        return this.complaintRepository.save(complaint);
    }
}
