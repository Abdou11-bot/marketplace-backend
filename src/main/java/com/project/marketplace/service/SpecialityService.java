package com.project.marketplace.service;

import com.project.marketplace.entity.Speciality;
import com.project.marketplace.repository.SpecialityRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {
    private final SpecialityRepository specialityRepositor;

    public SpecialityService(SpecialityRepository specialityRepositor) {
        this.specialityRepositor = specialityRepositor;
//        this.initDB();
    }

    public Speciality getSpeciality(long id){
        return this.specialityRepositor.findById(id).orElseThrow();
    }

    private void initDB() {
        this.specialityRepositor.save(new Speciality("Allergologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("Immunologie",500,"/images/Specialities/immunologie.jpg"));
        this.specialityRepositor.save(new Speciality("anesthésiologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("andrologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("cardiologie",500,"/images/Specialities/cardiologie.jpg"));
        this.specialityRepositor.save(new Speciality("chirurgie cardiaque",500,"/images/Specialities/chirurgie_cardiaque.jpg"));
        this.specialityRepositor.save(new Speciality("chirurgie plastique ",500,"/images/Specialities/chirurgie_plastique.jpg"));
        this.specialityRepositor.save(new Speciality("chirurgie générale",500,"/images/Specialities/chirurgie_cardiaque.jpg"));
        this.specialityRepositor.save(new Speciality("chirurgie maxillo-faciale",500,"/images/Specialities/chirurgie_maxillo-faciale.jpg"));
        this.specialityRepositor.save(new Speciality("chirurgie pédiatrique",500,"/images/Specialities/chirurgie_cardiaque.jpg"));
        this.specialityRepositor.save(new Speciality("chirurgie thoracique",500,"/images/Specialities/chirurgie_cardiaque.jpg"));
        this.specialityRepositor.save(new Speciality("chirurgie vasculaire",500,"/images/Specialities/chirurgie_vasculaire.jpg"));
        this.specialityRepositor.save(new Speciality("neurochirurgie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("dermatologie",500,"/images/Specialities/dermatologie.jpg"));
        this.specialityRepositor.save(new Speciality("endocrinologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("gastro-entérologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("gynécologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("hématologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("hépatologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("infectiologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("médecine aiguë",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("médecine du travail",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("médecine générale",500,"/images/Specialities/médecine_générale.jpg"));
        this.specialityRepositor.save(new Speciality("médecine interne",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("médecine nucléaire",500,"/images/Specialities/médecine_nucléaire.jpg"));
        this.specialityRepositor.save(new Speciality("médecine palliative",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("médecine physique",500,"/images/Specialities/médecine_physique.jpg"));
        this.specialityRepositor.save(new Speciality("médecine préventive",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("néonatologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("néphrologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("neurologie",500,"/images/Specialities/neurologie.png"));
        this.specialityRepositor.save(new Speciality("odontologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("oncologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("obstétrique",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("ophtalmologie",500,"/images/Specialities/ophtalmologie.png"));
        this.specialityRepositor.save(new Speciality("orthopédie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("Oto-rhino-laryngologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("pédiatrie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("pneumologie",500,"/images/Specialities/pneumologie.jpg"));
        this.specialityRepositor.save(new Speciality("psychiatrie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("radiologie",500,"/images/Specialities/radiologie.jpg"));
        this.specialityRepositor.save(new Speciality("radiothérapie",500,"/images/Specialities/radiothérapie.jpg"));
        this.specialityRepositor.save(new Speciality("rhumatologie",500,"/images/Specialities/img1.jpeg"));
        this.specialityRepositor.save(new Speciality("urologie",500,"/images/Specialities/img1.jpeg"));
    }
}
