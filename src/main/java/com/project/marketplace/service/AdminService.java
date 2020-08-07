package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.ProductRepository;
import com.project.marketplace.repository.ProviderRepository;
import com.project.marketplace.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminService {
    private final ProviderRepository providerRepository;
    private final ProductRepository productRepository;
    private final SpecialityRepository specialityRepository;

    public AdminService(ProviderRepository providerRepository, ProductRepository productRepository, SpecialityRepository specialityRepository) {
        this.providerRepository = providerRepository;
        this.productRepository = productRepository;
        this.specialityRepository = specialityRepository;
//        this.initDB();
        this.initDBProvider();
    }

    private void initDBProvider(){
        Provider provider = new Provider();
        provider.setStatus(1);
        provider.setEmail("admin@gmail.com tetettetetetet");
        provider.setFirstname("a");
        provider.setFirstname("adminFistname");
        provider.setLastname("adminLastname");
        provider.setPassword("12345");
        provider.setAdmin(true);
        provider.setTel("0606060606");
        Provider provider1=this.addProvider(provider);
    }
    private void initDB() {
        Provider provider = new Provider();
        provider.setFirstname("Provider  FirstName ");
        provider.setLastname("Provider  LastName ");
        provider.setEmail("tdrfygaz@ughzkajn.com ");
        provider.setPassword("ytughknjlaz, ");
        provider.setStatus(0);
        provider.setType(false);
        this.addProvider(provider);
    }


    public Provider addProvider(Provider provider) {
        return  this.providerRepository.save(provider);
    }

    public boolean blockProduct(long product) {
        Product product1 = this.productRepository.findById(product).orElseThrow();
        if(!product1.equals(null)){
            product1.setBlocked(true);
            this.productRepository.save(product1);
            return true;
        }
        return false;
    }

    public boolean activateProduct(long product) {
        Product product1 = this.productRepository.findById(product).orElseThrow();
        if(!product1.equals(null)){
            product1.setBlocked(false);
            this.productRepository.save(product1);
            return true;
        }
        return false;
    }

    public boolean blockProvider(long provider) {
        Provider provider1 = this.providerRepository.findById(provider).orElseThrow();
        if(!provider1.equals(null)){
            provider1.setStatus(-1);
            this.providerRepository.save(provider1);
            return true;
        }
        return false;
    }
    public boolean activateProvider(long provider) {
        Provider provider1 = this.providerRepository.findById(provider).orElseThrow();
        if(!provider1.equals(null)){
            provider1.setStatus(1);
            this.providerRepository.save(provider1);
            return true;
        }
        return false;
    }

    public boolean addSpeciality(Speciality speciality) {
        this.specialityRepository.save(speciality);
        return true;
    }

    public boolean deleteSpeciality(long id) {
        this.specialityRepository.deleteById(id);
        return !true;
    }

}
