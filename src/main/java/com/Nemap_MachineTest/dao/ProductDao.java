package com.Nemap_MachineTest.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Nemap_MachineTest.entity.Category;
import com.Nemap_MachineTest.entity.Product;
@Repository
public class ProductDao {

	@Autowired
	SessionFactory factory;
	public void insertProductdata(Product product) {
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(product);
		tx.commit();
	}
	public List<Product> fetchAllProductData() {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> allProductData=criteria.list();
		return allProductData;
	}

	public List<Product> getspecificProductid(long id) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> allProductData=criteria.list();
		
		return allProductData;
	}
	public void updateProductdetails(long id, Product product) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		//categoryToUpdate.setCname(category.getCname());
        // Add other fields that need to be updated
        //session.update(categoryToUpdate);
		session.update(product);
		tx.commit();
	}
	public void deleteSpecificProductId(long id) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Product pr=session.load(Product.class, id);
		session.delete(pr);
		tx.commit();
	}
	
	
}
