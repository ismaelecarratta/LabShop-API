package it.labshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.dao.CategoryDao;
import it.labshop.helpers.ResponseManager;
import it.labshop.model.Category;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryServiceImp implements CategoryService{

	@Autowired CategoryDao categoryDao;
	
	@Override
	public Iterable<Category> getAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category getById(int id) {
		Optional<Category> cat = categoryDao.findById(id);
		if( cat.isPresent() ) { return cat.get(); }
		else{ throw new EntityNotFoundException("Categoria non trovata"); }
	}

	@Override
	public Category save(Category cat) {
		categoryDao.save(cat);
		return cat;
	}

	@Override
	public ObjectNode deleteById(int id) {
		Optional<Category> cat = categoryDao.findById(id);
		
		if( cat.isPresent() ) { 
			categoryDao.deleteById(id);
			return new ResponseManager(200, "Categoria eliminata").getResponse();
		} 
		else { return new ResponseManager(404, "Categoria non trovata").getResponse(); }
	}

}
