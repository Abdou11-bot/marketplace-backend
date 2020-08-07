package com.project.marketplace.service;

import com.project.marketplace.entity.Provider;
import com.project.marketplace.entity.Speciality;
import org.springframework.stereotype.Service;

@Service
public class ProxyAdmin {
    private final AdminService adminService;
    private Provider provider;
    public ProxyAdmin(AdminService adminService) {
        this.adminService = adminService;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public boolean addProvider(Provider provider) {
        Provider provider1= this.adminService.addProvider(provider);
        if(provider1!=null)
            return true;
        return false;
    }

    public boolean blockProduct(long product) {
        return this.adminService.blockProduct(product);
    }
    public boolean activateProduct(long product) {
        return this.adminService.activateProduct(product);
    }

    public boolean blockProvider(long provider) {
        return this.adminService.blockProvider(provider);
    }
    public boolean activateProvider(long provider) {
        return this.adminService.activateProvider(provider);
    }

    public boolean addSpeciality(Speciality speciality) {
        return this.adminService.addSpeciality(speciality);
    }

    public boolean deleteSpeciality(long id) {
        return this.adminService.deleteSpeciality(id);
    }
}
