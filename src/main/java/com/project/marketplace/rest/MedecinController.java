package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.Medecin;
import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.service.MedecinService;
import com.project.marketplace.service.ProductService;
import com.project.marketplace.service.SpecialityService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/medecin")
public class MedecinController {
    private final MedecinService medecinService;
    private final ProductService productService;
    private final SpecialityService specialityService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    public MedecinController(MedecinService medecinService, ProductService productService, SpecialityService specialityService) {
        this.medecinService = medecinService;
        this.productService = productService;
        this.specialityService = specialityService;
    }

    @GetMapping("getAll")
    public List<Medecin> getAllMedecins() {
        return this.medecinService.getAllMedecins();
    }

    @GetMapping("get/{id}")
    public Medecin getMedecin(@PathVariable("id") long id){
        return this.medecinService.getMedecin(id);
    }


    @GetMapping("getByLogin/{login}")
    public Medecin getMedecinByEmail(@PathVariable("login") String login){
        return this.medecinService.getMedecin(login);
    }

    @GetMapping("logging")
    public Medecin loggingMedecin(@RequestParam("login") String login,@RequestParam("password") String password){
        return this.medecinService.getMedecin(login, (password));
    }
//
//    @GetMapping("logging")
//    public Boolean loggingMedecin(@RequestParam("login") String login,@RequestParam("password") String password){
//        if(this.medecinService.getMedecin(login, password).equals(null)){
//            return false;
//        }else {
//            return true;
//        }
//    }

    @PostMapping("add")
    public Medecin addMedecin(@RequestParam("data") String data,@RequestParam("speciality") String speciality) {
        Speciality speciality1 = this.specialityService.getSpeciality(Long.parseLong(speciality));
        Medecin medecin = new Gson().fromJson(data, Medecin.class);
        medecin.setSpeciality(speciality1);
        medecin.setPassword((medecin.getPassword()));
        return this.medecinService.addMedecin(medecin);
    }

    @PutMapping("addtowishlist/{medecin}/{product}")
    public List<Product> addtowishlist(@PathVariable("medecin") String medecin_login, @PathVariable("product") long product_id) {
        Product product = this.productService.getProduct(product_id);
        Medecin medecin = this.medecinService.getMedecin(medecin_login);
        List<Product> products = medecin.getProducts();
        boolean flag = false;
        for (Product product1:products) {
            if(product.getId()==product1.getId()){
                flag=true;
                break;
            }
        }
        if(!flag){
            products.add(product);
            medecin.setProducts(products);
            this.medecinService.addMedecin(medecin);
        }
        return  medecin.getProducts();
    }
    @PutMapping("deletfromwishlist/{medecin}/{product}")
    public List<Product> deletfromwishlist(@PathVariable("medecin") String medecin_login, @PathVariable("product") long product_id) {
        Product product = this.productService.getProduct(product_id);
        Medecin medecin = this.medecinService.getMedecin(medecin_login);
        List<Product> products = medecin.getProducts();
        int indice=-1;
        for (int i=0;i<products.size();i++) {
            if(products.get(i).getId()==product.getId()){
                indice = i;
                break;
            }
        }
        if(indice!=-1){
            products.remove(indice);
            medecin.setProducts(products);
            this.medecinService.addMedecin(medecin);
        }
        return  medecin.getProducts();
    }
    @PutMapping("emptywishlist/{medecin}")
    public List<Product> deletfromwishlist(@PathVariable("medecin") String medecin_login) {
        Medecin medecin = this.medecinService.getMedecin(medecin_login);
        medecin.setProducts(new ArrayList<Product>());
        this.medecinService.addMedecin(medecin);
        return  medecin.getProducts();
    }
    @GetMapping("getWishlist/{medecin}")
    public List<Product> getWidhlist(@PathVariable("medecin") String medecin_login) {
        Medecin medecin = this.medecinService.getMedecin(medecin_login);
        return  medecin.getProducts();
    }
    @GetMapping("existsInWishlist/{medecin}/{product}")
    public boolean existsInWishlist(@PathVariable("medecin") String medecin_login, @PathVariable("product") long product_id) {
        Medecin medecin = this.medecinService.getMedecin(medecin_login);
        List<Product> products = medecin.getProducts();
        for (Product product: products) {
            if(product.getId() == product_id){
                return true;
            }
        }
        return false;
    }

}
