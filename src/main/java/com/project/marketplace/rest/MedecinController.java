package com.project.marketplace.rest;

import com.google.gson.Gson;
import com.project.marketplace.entity.Medecin;
import com.project.marketplace.entity.Speciality;
import com.project.marketplace.service.MedecinService;
import com.project.marketplace.service.SpecialityService;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/api/medecin")
public class MedecinController {
    private final MedecinService medecinService;
    private final SpecialityService specialityService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    public MedecinController(MedecinService medecinService, SpecialityService specialityService) {
        this.medecinService = medecinService;
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

}
