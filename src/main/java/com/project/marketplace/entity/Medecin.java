package com.project.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String password;
	@Column
	private Date date;
	@Column
	private String email;
	@Column
	private String tel;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Speciality")
	private Speciality speciality;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "Medecin_Wishlist",
			joinColumns = {
					@JoinColumn(name = "medecin_id", referencedColumnName = "id",
							nullable = false, updatable = false)},
			inverseJoinColumns = {
					@JoinColumn(name = "product_id", referencedColumnName = "id",
							nullable = false, updatable = false)})
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
