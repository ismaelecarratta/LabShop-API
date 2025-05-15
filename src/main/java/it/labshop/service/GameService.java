package it.labshop.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.model.Game;

public interface GameService {

	Iterable<Game> getAll();
	Iterable<Game> getByRange( int start, int end);
	Iterable<Game> getBySearch( String text);
	Iterable<Game> getByFilter( int idCat, int idPlat, float price );
	Game getById( int id );
	Game save( Game cat );
	ObjectNode deleteById( int id );
	
	
	
}
