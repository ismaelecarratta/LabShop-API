package it.labshop.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.model.Category;

public interface CategoryService {
	
	Iterable<Category> getAll();
	Category getById( int id );
	Category save( Category cat );
	ObjectNode deleteById( int id );

}
