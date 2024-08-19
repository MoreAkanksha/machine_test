package com.Nemap_MachineTest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Nemap_MachineTest.entity.Category;
import com.Nemap_MachineTest.entity.Product;
import com.Nemap_MachineTest.service.ProductService;

@RestController
public class ProductController {
@Autowired
ProductService service;
@GetMapping("/test1")
public String test()
{
	return "TEST_1";
}

@PostMapping("/insertProductdata")
public void insertProductdata(@RequestBody Product product)
{
	service.insertProductdata(product);
}

@GetMapping("/fetchAllProductData")
public List<Product> fetchAllProductData()
{
	return service.fetchAllProductData();
}
@GetMapping("getspecificProductId/{id}")
public Map<String,Object> getspecificProductId(@PathVariable long id)
{
	return service.getspecificProductId(id);
}
@PutMapping("updateProductdetails/{id}")
public void updateProductdetails(@PathVariable long id, @RequestBody Product product)
{
	service.updateProductdetails(id,product);
}

@DeleteMapping("DeleteSpecificProductId/{id}")
public void DeleteSpecificProductId(@PathVariable long id)
{
	service.DeleteSpecificProductId(id);
}



	
}
