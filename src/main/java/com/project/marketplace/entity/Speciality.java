package com.project.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String image;
    @Column
    private double priceSpeciality;
    @JsonIgnore
    @ManyToMany(mappedBy = "Specialities", fetch = FetchType.LAZY)
    private List<Provider> providers ;

    //    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "Specialities")
//    @ManyToMany(mappedBy = "Specialities")
//    private List<Provider> providers;
//    ArrayList<Medecin> medecin = new ArrayList<Medecin>();
//    ArrayList<Provider> avoir = new ArrayList<Provider>();
//    ArrayList<Product> appartenir = new ArrayList<Product>();


    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public Speciality() {}

    public Speciality(String name, double priceSpeciality, String image) {
        this.name = name.toUpperCase();
        this.priceSpeciality = priceSpeciality;
        this.image = image;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPriceSpeciality(double priceSpeciality) {
        this.priceSpeciality = priceSpeciality;
    }

    public double getPriceSpeciality() {
        return this.priceSpeciality;
    }

//    public List<Provider> getProviders() {
//        return providers;
//    }
//
//    public void setProviders(List<Provider> providers) {
//        this.providers = providers;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
