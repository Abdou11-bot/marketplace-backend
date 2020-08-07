package com.project.marketplace.service;

import com.project.marketplace.entity.*;
import com.project.marketplace.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final SpecialityRepository specialityRepository;
    private final ProductRepository productRepository;
    private final ComplaintRepository  complaintRepository;
    private final QuotationRepository quotationRepository;

    public ProviderService(ProviderRepository providerRepository, SpecialityRepository specialityRepository, ProductRepository productRepository, ComplaintRepository complaintRepository, QuotationRepository quotationRepository) {
        this.providerRepository = providerRepository;
        this.specialityRepository = specialityRepository;
        this.productRepository = productRepository;
//        this.initDB();
//        this.updateDB();
//        System.out.println(this.afficher(this.getAdmin()));
        this.complaintRepository = complaintRepository;
        this.quotationRepository = quotationRepository;
    }

    private void initDB() {
        for(int i=0;i<10;i++) {
            Product product = new Product();
            product.setName("Product " + (i + 1) + " Name ");
            product.setDescription("Product " + (i + 1) + " Description ");
            product.setCatalogue("Product " + (i + 1) + " Catalogue ");
            product.setMarque("Product " + (i + 1) + " Marque ");
            this.addProduct(product);
        }
    }

    public Provider getProvider(long id){
        return this.providerRepository.findById(id).orElseThrow();
    }

    public Provider getProviderByEmail(String mail){
        return this.providerRepository.findFirstByEmailEquals(mail);
    }

    public Provider getAdmin(){
        return this.providerRepository.findFirstByAdminEquals(true);
    }

    private void updateDB() {
        for(int i=0;i<10;i++){
            Provider provider = this.providerRepository.findById((long)(i+1+10)).orElseThrow();
            Product product = this.productRepository.findById((long)(i+1)).orElseThrow();
            product.setProvider(provider);
            this.updateProduct(product.getId(),product);
        }
    }


//    public Provider getAdmin() {
//        return this.providerRepository.findFirstByAdminEquals(true);
//    }

    public Provider updateProfil(long id, Provider provider) {
        Provider provider1 = this.providerRepository.findById(provider.getId()).orElseThrow();
        if (!provider1.equals(null)){
            provider.setId(id);
            provider1 = this.providerRepository.save(provider);
        }
        return provider1;
    }


    /*Start product */
    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }

    public long getLastProductId(){
        List<Product> produits = this.productRepository.findAll();
        long id=-1;
        if(produits.size()==0) {
            id=1;
        }else{
            for (Product product1: produits) {
                if(product1.getId()>id)
                    id=product1.getId();
            }
        }
        return id;
    }

    public Product updateProduct(long idProduct, Product newProduct) {
        Product oldProduct = getProduct(idProduct);
        if(oldProduct!=null){
            newProduct.setId(idProduct);
//            System.out.println("success");
            return this.productRepository.save(newProduct);
        }
//        System.out.println("failed ");
        return null;
    }

    public boolean deleteProduct(long id) {
        this.productRepository.deleteById(id);
        return true;
    }
//    public String afficher( Provider Admin){
//        return "Admin ["+ Admin.getFirstname()+"; "+ Admin.getLastname()+"; "+ Admin.getEmail()+"; "
//                + Admin.getPassword()+"; "+ Admin.getTel()+"; "+ Admin.getStatus()+"] ";
//    }

    public Product getProduct(long id) {
        return this.productRepository.findById(id).orElseThrow();
    }

    public List<Product> getOwnedProducts(long id) {
        List<Product> products =null;
        products =this.productRepository.findAllByProviderEquals(this.getProvider(id));
        return products;
    }

    public List<Product> getClaimedProducts(long id) {
        List<Product> products = new ArrayList<Product>();
        products =this.productRepository.findAllByProviderEquals(this.getProvider(id));
        List<Complaint> complaints =new ArrayList<Complaint>();
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
        return products;
    }

    public List<Product> getQuotations(long id) {
        List<Product> products = new ArrayList<Product>();
        products =this.productRepository.findAllByProviderEquals(this.getProvider(id));
        List<Quotation> quotations =new ArrayList<Quotation>();
        for (Product product:products) {
            quotations.addAll(this.quotationRepository.findAllByProductEquals(product));
        }
        Collections.sort(quotations, new Comparator<Quotation>() {
            @Override
            public int compare(Quotation o1, Quotation o2)
            {
                return (o1.getId() < o2.getId() ? -1 :
                        (o1.getId() == o2.getId() ? 0 : 1));
            }
        });
        return products;
    }

    public Product[] getOwnedProducts() {
        throw new UnsupportedOperationException();
    }
    /*End product */

    /*Start speciality */
//    public boolean addSpeciality(Speciality speciality) {
//        this.specialityRepository.save(speciality);
//        return true;
//    }

    public boolean updateSubscription(int subscription) {
        throw new UnsupportedOperationException();
    }

    public List<Speciality> getAllSpecialitys() {
        return this.specialityRepository.findAll();
    }
    public List<Speciality> getAllSpecialitiesSuscribed() {
        List<Provider> providers =  this.providerRepository.findAll();
        List<Speciality> specialities = new ArrayList<>();
        List<Speciality> specialities1 = new ArrayList<>();
        for (Provider provider: providers) {
            specialities.addAll(provider.getSpecialities());
        }
        for (Speciality speciality: specialities) {
            if(!specialities1.contains(speciality))
                specialities1.add(speciality);
        }
        return specialities1;
    }
    public List<Provider> getAllProviders() {
        return this.providerRepository.findAll();
    }

//    public boolean deleteSpeciality() {
//        throw new UnsupportedOperationException();
//    }

    /*End speciality */
}
