package it.labshop.dao;

import org.springframework.data.repository.CrudRepository;
import it.labshop.model.Category;

public interface CategoryDao extends CrudRepository<Category, Integer>{}
