package com.Nemap_MachineTest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Nemap_MachineTest.dao.CategoryDao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Product {
	
	@Id
	long pid;
	String pname;
	double pprice;
	
	 @ManyToOne
	    @JoinColumn(name="cid")
	    @JsonIgnore
	    Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(long pid, String pname, double pprice, Category category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.category = category;
	}

	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	

    @JsonProperty("cid")
    public Long getCid() {
        return category != null ? category.getCid() : null;
    }
    public void setCid(Long cid) {
    	 if (this.category == null) {
             this.category = new Category();
         }
         this.category.setCid(cid);
    }
    @JsonProperty("cname")
    public String getCname() {
        return category != null ? category.getCname() : null;
    }
//    public void setCname(Long cname) {
//    	 if (this.category == null) {
//             this.category = new Category();
//         }
//         this.category.setCname(cname);
//    }
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", cid=" + getCid() + ",cname=" + getCname() + "]";
	}
	
}
