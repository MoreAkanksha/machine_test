package com.Nemap_MachineTest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Category {

	@Id
	Long cid;
	String cname;
	
	

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("category") 
	List<Product> productli;


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(Long cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}


	public Long getCid() {
		return cid;
	}


	public void setCid(Long cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public List<Product> getProductli() {
		return productli;
	}


	public void setProduct(List<Product> productli) {
		this.productli = productli;
	}


	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
