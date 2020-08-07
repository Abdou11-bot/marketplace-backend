package com.project.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private boolean admin;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String tel;
    @Column
    private int status;
    @Column
    private Date date;
    @Column
    private boolean type;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Society")
    private Society Society;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "Provider_Speciality",
            joinColumns = {
                    @JoinColumn(name = "speciality_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "provider_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Speciality> Specialities;

    //    ArrayList<Product> product = new ArrayList<Product>();

//    @JoinTable(name = "providers", joinColumns = @JoinColumn(name = "provider_id"),
//            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
//    List<Speciality> Specialities;
//    AbstractAdmin abstractAdmin;


    public com.project.marketplace.entity.Society getSociety() {
        return Society;
    }

    public void setSociety(com.project.marketplace.entity.Society society) {
        Society = society;
    }

    public List<Speciality> getSpecialities() {
        return Specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        Specialities = specialities;
    }

    public void setId(long id) { this.id = id; }

    public long getId() { return this.id; }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isType() {
        return this.type;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Society getAppartenir() {
        return Society;
    }

    public void setAppartenir(Society appartenir) {
        this.Society = appartenir;
    }

}
