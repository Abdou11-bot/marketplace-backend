package com.project.marketplace.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Quotation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String lastname;
	@Column
	private String firstname;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String quantity;
	@Column
	private String postalCode;
	@Column
	private Date date;
	@Column
	private boolean traiter;
	@Column
	private String locality;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	private Product product;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public boolean isTraiter() {
		return traiter;
	}

	public void setTraiter(boolean traiter) {
		this.traiter = traiter;
	}
}
