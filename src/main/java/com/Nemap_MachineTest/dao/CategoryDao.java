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

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory factory;

	public void insertdata(Category category) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(category);
		tx.commit();
	}

	public List<Category> fetchAllCategoryData() {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Category.class);
		List<Category> allCategoryData=criteria.list();
		return allCategoryData;
	
		
	}
	public List<Category> getspecificId(long id) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Category.class);
		List<Category> allData=criteria.list();
		
		return allData;
	}

	public void updateCategorydetails(long id,Category category) {
		// TODO Auto-generated method stub
		//Category categoryToUpdate =getspecificId(id);
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		//categoryToUpdate.setCname(category.getCname());
        // Add other fields that need to be updated
        //session.update(categoryToUpdate);
		session.update(category);
		tx.commit();
	}

	public void deleteSpecificCategoryId(long id) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Category cr=session.load(Category.class, id);
		session.delete(cr);
		tx.commit();
	}
//	public Optional<Category> findById(Long cid) {
//        Session session = factory.openSession();
//        Category category = session.get(Category.class, cid);
//        session.close();
//        return Optional.ofNullable(category);
//    }
	
}
