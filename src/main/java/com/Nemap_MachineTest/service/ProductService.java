package com.Nemap_MachineTest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nemap_MachineTest.dao.ProductDao;
import com.Nemap_MachineTest.dao.CategoryDao;

import com.Nemap_MachineTest.entity.Category;
import com.Nemap_MachineTest.entity.Product;
@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	@Autowired
	CategoryService categoryService;
	public void insertProductdata(Product product) {
//		 Long cid = product.getCid();
//	        if (cid != null) {
//	            Category category = categoryService.findCategoryById(cid);
//	            product.setCategory(category);
//	        }
	        
	        dao.insertProductdata(product);
	}

	public List<Product> fetchAllProductData() {
		// TODO Auto-generated method stub
		return dao.fetchAllProductData();
	}

	public Map<String,Object>  getspecificProductId(long id) {
		List<Product> allProductData=dao.fetchAllProductData();

//		ArrayList<Object> pidlist = new ArrayList<Object>();
//		for (Product product : allProductData) {
//			if (product.getPid() == id) {
//				pidlist.add(product.getPid());
//				pidlist.add( product.getPname());
//				pidlist.add( product.getPprice());
//				pidlist.add(product.getCid());
//				pidlist.add(product.getCname());
//				
//			}
//		}
//		return pidlist;
		//-------------------------------------------------------
		Map<String,Object> hm=new HashMap<String, Object>();
		for (Product product : allProductData) {
			if (product.getPid() == id) {
				hm.put("Product Id", product.getPid());
				hm.put("Product Name", product.getPname());
				hm.put("Product Price", product.getPprice());
				hm.put("Category Id", product.getCid());
				hm.put("CAtegory Name", product.getCname());
				
			}
		}
		return hm;	
		
//		 Optional<Product> productOptional = dao.findById(id);
//	        if (productOptional.isPresent()) {
//	            Product product = productOptional.get();
//	            Product productDTO = new Product();
//	            productDTO.setPid(product.getPid());
//	            productDTO.setPname(product.getPname());
//	            productDTO.setPprice(product.getPprice());
//
//	            Category category = product.getCategory();
//	            if (category != null) {
//	                Category categoryDTO = new Category();
//	                categoryDTO.setCid(category.getCid());
//	                categoryDTO.setCname(category.getCname());
//	                productDTO.setCategory(categoryDTO);
//	            }
//
//	            return productDTO;
//	        }
//	        return null;
	}

	public boolean updateProductdetails(long id, Product product) {
		
		List<Product> allProductData=dao.fetchAllProductData();
		HashMap<Long ,String> specificID=new HashMap<Long ,String>();
		for (Product fetchid : allProductData) {
			if(fetchid.getPid()==id)
			{
				dao.updateProductdetails(id,product);
				return true;
			}
			
		}
		return false;
		
	}

	public void DeleteSpecificProductId(long id) {
		// TODO Auto-generated method stub
		dao.deleteSpecificProductId(id);
	}
}
