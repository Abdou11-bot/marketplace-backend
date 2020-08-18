package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.Medecin;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final ProviderService providerService;
    private final MedecinService medecinService;
    private final ProxyAdmin proxyAdmin;
    private final ImageController imageController;
    private final ImageService imageService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
    @Autowired
    private ImageStorageService imageStorageService;

    public AdminController(ProviderService providerService, MedecinService medecinService, ProxyAdmin proxyAdmin, ImageController imageController, ImageService imageService) {
        this.providerService = providerService;
        this.medecinService = medecinService;
        this.proxyAdmin = proxyAdmin;
        this.imageController = imageController;
        this.imageService = imageService;
    }
    @GetMapping("/login")
    public int login(@RequestParam("login") String login, @RequestParam("password") String password){
        Provider provider=null;
        provider = this.providerService.getProviderByEmail(login);
        if(provider == null)
            return -1;
        if(provider.getPassword().equals(password)){
            if(provider.isAdmin()){
                return 1;
            }
            return 0;
        }
        return -1;
    }
//    @GetMapping("/login/{admin}")
//    public boolean login(@PathVariable("admin") String admin, @RequestParam("login") String login, @RequestParam("password") String password){
//        Provider provider=null;
//        if (admin.equals("admin")) {
//            provider = this.providerService.getAdmin();
//        }else{
//            provider = this.providerService.getProviderByEmail(login);
//        }
//        if(provider == null)
//            return false;
//        if(provider.getPassword().equals(password))
//            return true;
//        return false;
//    }
    @PutMapping("/updateAdmin")
    public Provider updateAdmin(@Valid @RequestParam("admin") String adminData) {
        Provider admin = new Gson().fromJson(adminData, Provider.class); ;
        Provider admin1 = this.providerService.getAdmin();
        admin.setId(admin1.getId());
        admin.setPassword((admin.getPassword()));
//        admin.setPassword((admin.getPassword()));
        return this.providerService.updateProfil(admin1.getId(),admin);
    }
    @GetMapping("/getAdmin")
    public Provider getAdmin(){
        Provider Admin = this.providerService.getAdmin();
        return Admin;
    }
    @GetMapping("/blockproduct/{id}")
    public boolean blockProduct(@PathVariable("id") long id){
        return this.proxyAdmin.blockProduct(id);
    }

    @GetMapping("/activateproduct/{id}")
    public boolean activateProduct(@PathVariable("id") long id){
        return this.proxyAdmin.activateProduct(id);
    }
    @GetMapping("/blockprovider/{id}")
    public boolean blockProvider(@PathVariable("id") long id){
        return this.proxyAdmin.blockProvider(id);
    }

    @GetMapping("/activateprovider/{id}")
    public boolean activateProvider(@PathVariable("id") long id){
        return this.proxyAdmin.activateProvider(id);
    }

    @GetMapping("/providersExists/{login}")
    public boolean providersExists(@PathVariable("login") String login) {
        Provider provider = null;
        provider = this.providerService.getProviderByEmail(login);
        if(provider == null){
            return false;
        }
        return true;
    }
    @GetMapping("/medecinExists/{login}")
    public boolean medecinExists(@PathVariable("login") String login) {
        Medecin medecin = null;
        medecin = this.medecinService.getMedecin(login);
        if(medecin == null){
            return false;
        }
        return true;
    }
}
