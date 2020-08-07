package com.project.marketplace.entity;

import javax.persistence.*;

@Entity
public class Society {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String numero_tel;
    @Column
    private String email;
    @OneToOne
    private Provider responsable;


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

    public void setNumero_tel(String numero_tel) {
        this.numero_tel = numero_tel;
    }

    public String getNumero_tel() {
        return this.numero_tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}
