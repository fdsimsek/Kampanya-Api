package com.allianzCase.project.insuranceOffer.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="offers")
public class Offer {
	
	@Id
	@Column(name="id")
	private int id;
	
	@NotNull
	@Column(name="header")
	@Size(min=10, max=50, message = "Kampanya ilan başlığı 10 ila 50 karakter arasında olmalıdır!")
	@Pattern(regexp = "^[a-zA-Z0-9ıIğüşöçİĞÜŞÖÇ\s]+$")
	private String header;
	
	@NotNull
	@Column(name="detail")
	@Size(min = 20, max = 200, message= "Kampanya ilan detayı 20 ila 200 karakter arasında olmalıdır!")
	private String detail;
	
	@NotNull
	@Column(name="category")	
	private String category;
	
	@Column(name="status")
	private String status;
	
	@Column(name="is_mukerrer")
	private int is_mukerrer;
	
	public Offer(int id, String header, String detail, String category, String status, int is_mukerrer) {
		super();
		this.id = id;
		this.header = header;
		this.detail = detail;
		this.category = category;
		this.status = status;
		this.is_mukerrer = is_mukerrer;
	}
	
	public Offer() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public int getIs_mukerrer() {
		return is_mukerrer;
	}

	public void setIs_mukerrer(int is_mukerrer) {
		this.is_mukerrer = is_mukerrer;
	
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", header=" + header + ", detail=" + detail + ", category=" + category + ", status="
				+ status + ", is_mukerrer=" + is_mukerrer + "]";
	}


}
