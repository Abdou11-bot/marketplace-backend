package com.project.marketplace.service;

import com.project.marketplace.entity.Medecin;
import com.project.marketplace.repository.MedecinRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MedecinService {
    private final MedecinRepository MedecinRepository;

    public MedecinService(MedecinRepository MedecinRepository) {
        this.MedecinRepository = MedecinRepository;
//        this.initDB();
    }
    private void initDB() {
        Medecin medecin = new Medecin();
        medecin.setEmail("Abdou@gmail.com");
        medecin.setPrenom("CIN1");
        medecin.setPassword("password");
        medecin.setNom("Laouali");
        this.addMedecin(medecin);
    }
//
//    public Complaint addComplaint(Complaint complaint) {
//        return this.complaintRepository.save(complaint);
//    }

    public Medecin getMedecin(long id){
        return this.MedecinRepository.findById(id).orElseThrow();
    }
    public Medecin getMedecin(String login, String password){
        return this.MedecinRepository.findByEmailEqualsAndPasswordEquals(login,password);
    }
    public Medecin getMedecin(String login){
        return this.MedecinRepository.findByEmailEquals(login);
    }
    public Medecin addMedecin(Medecin medecin){
        medecin.setDate(new Date());
        return this.MedecinRepository.save(medecin);
    }
    public List<Medecin> getAllMedecins(){
        return this.MedecinRepository.findAll();
    }

    public void RequestQuotation() {

    }
}
