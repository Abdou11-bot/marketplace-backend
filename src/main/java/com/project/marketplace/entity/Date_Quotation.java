package com.project.marketplace.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Date_Quotation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private Date date;
	@Column
	private String locality;
	@OneToOne
	@JoinColumn(name = "quotation_id")
	Quotation quotation;
	@OneToOne
	@JoinColumn(name = "product_id")
	Product product;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	public Quotation getQuotation() {
		return this.quotation;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return this.product;
	}

//	public int hashCode() {
//		int lHashCode = 0;
//		if ( this.date != null ) {
//			lHashCode += this.date.hashCode();
//		}
//		if ( this.locality != null ) {
//			lHashCode += this.locality.hashCode();
//		}
//		if ( this.quotation != null ) {
//			lHashCode += this.quotation.hashCode();
//		}
//		if ( this.product != null ) {
//			lHashCode += this.product.hashCode();
//		}
//		if ( lHashCode == 0 ) {
//			lHashCode = super.hashCode();
//		}
//		return lHashCode;
//	}
//
//	public boolean equals(Object object) {
//		if (this == object) {
//			return true;
//		} else if (object instanceof Date_Quotation) {
//			Date_Quotation lDate_QuotationObject = (Date_Quotation) object;
//			boolean lEquals = true;
//			lEquals &= ((this.date == lDate_QuotationObject.date)
//				|| (this.date != null && this.date.equals(lDate_QuotationObject.date)));
//			lEquals &= ((this.locality == lDate_QuotationObject.locality)
//				|| (this.locality != null && this.locality.equals(lDate_QuotationObject.locality)));
//			lEquals &= ((this.quotation == lDate_QuotationObject.quotation)
//				|| (this.quotation != null && this.quotation.equals(lDate_QuotationObject.quotation)));
//			lEquals &= ((this.product == lDate_QuotationObject.product)
//				|| (this.product != null && this.product.equals(lDate_QuotationObject.product)));
//			return lEquals;
//		}
//		return false;
//	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
}
