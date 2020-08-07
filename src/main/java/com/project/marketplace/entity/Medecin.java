package com.project.marketplace.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String password;
	@Column
	private Date date;
	@Column
	private String email;
	@Column
	private boolean admin = false;
	@Column
	private String tel;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Speciality")
	private Speciality speciality;
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
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


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

}
