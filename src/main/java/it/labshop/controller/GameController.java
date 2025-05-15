package it.labshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.model.Game;
import it.labshop.service.GameService;


@RestController
@RequestMapping("game")
public class GameController {

	@Autowired GameService gameService;
	
	@GetMapping("all")
	public Iterable<Game> getAllGames(){
		return gameService.getAll();
	}
	
	@GetMapping("{id}")
	public Game getGameById( @PathVariable( name = "id" ) int id){
		return gameService.getById(id);
	}
	
	@GetMapping("range")
	public Iterable<Game> getGameByRange( 
			@RequestParam( name="start", required = true) int start,
			@RequestParam( name="end", required = true) int end
	){
		return gameService.getByRange(start, end);
	}
	
	@GetMapping("filter")
	public Iterable<Game> getGameByFilter( 
			@RequestParam( name="cat",   required = true, defaultValue = "0") int idCat,
			@RequestParam( name="plat",  required = true, defaultValue = "0") int idPlat,
			@RequestParam( name="price", required = true, defaultValue = "0") int pr
	){
		return gameService.getByFilter(idCat, idPlat, (float)pr);
	}
	
	
	@GetMapping("search")
	public Iterable<Game> getGameBySearch( @RequestParam( name="text", required = true) String text ){
		return gameService.getBySearch(text);
	}
	
	

	@PostMapping("save")
	public Game saveGame( @RequestBody Game game ) {
		return gameService.save(game);
	}
	
	@PutMapping("update")
	public Game updateGame( @RequestBody Game game ) {
		return gameService.save(game);
	}
	
	@DeleteMapping("delete/{id}")
	public ObjectNode deleteGameById( @PathVariable( name = "id" ) int id ){ 
		return gameService.deleteById(id);
	}
	
}
