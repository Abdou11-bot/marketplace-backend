package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.Image;
import com.project.marketplace.entity.Product;
import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.service.ImageService;
import com.project.marketplace.service.ImageStorageService;
import com.project.marketplace.service.ProviderService;
import com.project.marketplace.service.ProxyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final ProviderService providerService;
    private final ProxyAdmin proxyAdmin;
    private final ImageController imageController;
    private final ImageService imageService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
    @Autowired
    private ImageStorageService imageStorageService;

    public AdminController(ProviderService providerService, ProxyAdmin proxyAdmin, ImageController imageController, ImageService imageService) {
        this.providerService = providerService;
        this.proxyAdmin = proxyAdmin;
        this.imageController = imageController;
        this.imageService = imageService;
    }
    @GetMapping("/login/{admin}")
    public boolean login(@PathVariable("admin") String admin, @RequestParam("login") String login, @RequestParam("password") String password){
        Provider provider=null;
        if (admin.equals("admin")) {
            provider = this.providerService.getAdmin();
        }else{
            provider = this.providerService.getProviderByEmail(login);
        }
        if(provider == null)
            return false;
        if(provider.getPassword().equals(password))
            return true;
        return false;
    }
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

}
