package com.Nemap_MachineTest.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nemap_MachineTest.dao.CategoryDao;
import com.Nemap_MachineTest.entity.Category;
@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;

	public void insertdata(Category category) {
		dao.insertdata(category);
	}

	public List<Category> fetchAllCategoryData() {
		// TODO Auto-generated method stub
		return dao.fetchAllCategoryData();
	}

	public HashMap<Long, String> getspecificCategoryId(long id) {
		// TODO Auto-generated method stub
		List<Category> allData=dao.fetchAllCategoryData();
		HashMap<Long ,String> specificCategoryID=new HashMap<Long ,String>();
		for (Category fetchid : allData) {
			if(fetchid.getCid()==id)
			{
				specificCategoryID.put(fetchid.getCid(),fetchid.getCname());
			}
		}
		
		return specificCategoryID;
	}

	public boolean UpdateCategorydetails(long id ,Category category) {
		// TODO Auto-generated method stub
		List<Category> allData=dao.fetchAllCategoryData();
		HashMap<Long ,String> specificID=new HashMap<Long ,String>();
		for (Category fetchid : allData) {
			if(fetchid.getCid()==id)
			{
				dao.updateCategorydetails(id,category);
				return true;
			}
			
		}
		return false;
	}

	public void DeleteSpecificCategoryId(long id) {
		// TODO Auto-generated method stub
		dao.deleteSpecificCategoryId(id);
	}

//	public Category findCategoryById(Long cid) {
//        // Implement your logic to find the category
//        return dao.findById(cid).orElse(null);
//    }
	
	
}
