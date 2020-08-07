package com.project.marketplace.service;

import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.ProductRepository;
import com.project.marketplace.repository.ProviderRepository;
import com.project.marketplace.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;
    private final SpecialityRepository specialityRepository;

    public ProductService(ProductRepository productRepository, ProviderRepository providerRepository, SpecialityRepository specialityRepository) {
        this.productRepository = productRepository;
        this.providerRepository = providerRepository;
        this.specialityRepository = specialityRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
    public List<Product> getAllProductsForSpeciality(Speciality speciality) {
        return this.productRepository.findAllBySpecialityEquals(speciality);
    }
    public Product getProduct(long id) {
        return this.productRepository.findById(id).orElseThrow();
    }
    public List<Product> getResearchResult(String[] params) {
        Speciality speciality = this.specialityRepository.findById(Long.parseLong(params[0].trim())).orElseThrow();
        Provider provider = this.providerRepository.findById(Long.parseLong(params[1].trim())).orElseThrow();
        return this.productRepository.findAllBySpecialityEqualsAndProviderEqualsAndMarqueContainingOrDescriptionContainingOrNameContaining(
                speciality, provider, params[2].trim(), params[2].trim(), params[2].trim().trim());
    }
    public List<Product> getResearchResult(String param, String type) {
        if(type.trim().equals("speciality")){
            Speciality speciality = this.specialityRepository.findById(Long.parseLong(param.trim())).orElseThrow();
            return this.productRepository.findAllBySpecialityEquals(speciality);
        }else{
            if(type.trim().equals("provider")){
                Provider provider = this.providerRepository.findById(Long.parseLong(param.trim())).orElseThrow();
                return this.productRepository.findAllByProviderEquals(provider);
            }else{
                return this.productRepository.findAllByMarqueContainingOrDescriptionContainingOrNameContaining( param.trim(), param.trim(), param.trim());
            }
        }
    }
    public List<Product> getResearchResult(String[] params, String type) {
        if(type.trim().equals("ProviderAndProduct")){
            Provider provider = this.providerRepository.findById(Long.parseLong(params[0])).orElseThrow();
            return this.productRepository.findAllByProviderEqualsAndMarqueContainingOrDescriptionContainingOrNameContaining( provider, params[1], params[1], params[1]);
        }else{
            if(type.trim().equals("SpecialityAndProvider")){
                Speciality speciality = this.specialityRepository.findById(Long.parseLong(params[0].trim())).orElseThrow();
                Provider provider = this.providerRepository.findById(Long.parseLong(params[1].trim())).orElseThrow();
                return this.productRepository.findAllBySpecialityEqualsAndProviderEquals( speciality, provider);
            }else{
                Speciality speciality = this.specialityRepository.findById(Long.parseLong(params[0].trim())).orElseThrow();
                return this.productRepository.findAllBySpecialityEqualsAndMarqueContainingOrDescriptionContainingOrNameContaining( speciality, params[1].trim(), params[1].trim(), params[1].trim());
            }

        }
    }
    public Product getMostView() {
        return this.productRepository.findFirstByOrderByNombreVueDesc();
    }
    public Product incrementView(long id) {
        Product product = this.getProduct(id);
        product.setNombreVue(product.getNombreVue()+1);
        return this.productRepository.save(product);
    }

}
