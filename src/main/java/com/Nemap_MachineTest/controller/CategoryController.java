package com.Nemap_MachineTest.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Nemap_MachineTest.entity.Category;
import com.Nemap_MachineTest.service.CategoryService;
@RestController
public class CategoryController {

	@Autowired
	CategoryService service;
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}
	
	@PostMapping("/insertCategorydata")
	public void insertdata(@RequestBody Category category)
	{
		service.insertdata(category);
	}
	
	@GetMapping("/fetchAllCategoryData")
	public List<Category> fetchAllCategoryData()
	{
		return service.fetchAllCategoryData();
	}
	@GetMapping("getspecificCategoryId/{id}")
	public HashMap<Long, String> getspecificCategoryId(@PathVariable long id)
	{
		return service.getspecificCategoryId(id);
	}
	@PutMapping("UpdateCategorydetails/{id}")
	public void UpdateCategorydetails(@PathVariable long id, @RequestBody Category category)
	{
		service.UpdateCategorydetails(id,category);
	}
	
	@DeleteMapping("DeleteSpecificCategoryId/{id}")
	public void DeleteSpecificCategoryId(@PathVariable long id)
	{
		service.DeleteSpecificCategoryId(id);
	}
	
}
