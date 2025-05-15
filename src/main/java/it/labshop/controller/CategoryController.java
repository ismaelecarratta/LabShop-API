package it.labshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.model.Category;
import it.labshop.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired CategoryService categoryService;
	
	@GetMapping("all")
	public Iterable<Category> getAllCategory(){
		return categoryService.getAll();
	}
	
	@GetMapping("{id}")
	public Category getCategoryById( @PathVariable( name = "id" ) int id){
		return categoryService.getById(id);
	}
	
	@PostMapping("save")
	public Category saveCategory( @RequestBody Category cat ) {
		return categoryService.save(cat);
	}
	
	@PutMapping("update")
	public Category updateCategory( @RequestBody Category cat ) {
		return categoryService.save(cat);
	}
	
	@DeleteMapping("delete/{id}")
	public ObjectNode deleteCategoryById( @PathVariable( name = "id" ) int id ){ 
		return categoryService.deleteById(id);
	}
	
}
