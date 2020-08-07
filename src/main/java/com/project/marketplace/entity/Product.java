package com.project.marketplace.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String catalogue;
	@Column
	private String reference;
	@Column
	private long nombreVue;
	@Column
	private String marque;
	@Column
	private boolean blocked=false;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "provider_id")
	private Provider provider;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id")
	private List<Image> images;
//	ArrayList<Complaint> reclamer = new ArrayList<Complaint>();
//	ArrayList<Date_Quotation> date_Quotation = new ArrayList<Date_Quotation>();
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "speciality")
	private Speciality speciality;
//	Provider provider;


	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public void setId(long id) { this.id = id; }

	public long getId() { return this.id; }

	public void setName(String name) { this.name = name; }

	public String getName() { return this.name; }

	public void setDescription(String description) { this.description = description; }

	public String getDescription() { return this.description; }

	public void setCatalogue(String catalogue) { this.catalogue = catalogue; }

	public String getCatalogue() { return this.catalogue; }

	public void setReference(String reference) { this.reference = reference; }

	public String getReference() { return this.reference; }

	public void setNombreVue(long nombreVue) { this.nombreVue = nombreVue; }

	public long getNombreVue() { return this.nombreVue; }

	public void setMarque(String marque) { this.marque = marque; }

	public String getMarque() {
		return this.marque;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
