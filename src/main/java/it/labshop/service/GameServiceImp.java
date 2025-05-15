package it.labshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.dao.GameDao;
import it.labshop.helpers.ResponseManager;
import it.labshop.model.Game;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GameServiceImp implements GameService {

	@Autowired GameDao gameDao;
	
	@Override
	public Iterable<Game> getAll() {
		return gameDao.findAll();
	}
	
	@Override
	public Iterable<Game> getByRange( int start, int end ) {
		return gameDao.findByRange( start, end );
	}
	
	@Override
	public Iterable<Game> getBySearch( String text ) {
		return gameDao.findBySearch( "%" + text + "%");
	}
	
	@Override
	public Iterable<Game> getByFilter( int idCat, int idPlat, float pr ) {
		return gameDao.findByFilter(idCat, idPlat, pr);
	}

	@Override
	public Game getById(int id) {
		Optional<Game> game = gameDao.findById(id);
		if( game.isPresent() ) { return game.get(); }
		else{ throw new EntityNotFoundException("Gioco non trovato"); }
	}

	
	@Override
	public Game save(Game game) {
		gameDao.save(game);
		return game;
	}

	@Override
	public ObjectNode deleteById(int id) {
		Optional<Game> game = gameDao.findById(id);
		
		if( game.isPresent() ) { 
			gameDao.deleteById(id);
			return new ResponseManager(200, "Gioco eliminato").getResponse();
		} 
		else { return new ResponseManager(404, "Gioco non trovato").getResponse(); }
	}




}
