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
import it.labshop.model.Platform;
import it.labshop.service.PlatformService;

@RestController
@RequestMapping("platform")
public class PlatformController {
	
	@Autowired PlatformService platformService;
	
	@GetMapping("all")
	public Iterable<Platform> getAllPlatform(){
		return platformService.getAll();
	}
	
	@GetMapping("{id}")
	public Platform getPlatformById( @PathVariable( name = "id" ) int id){
		return platformService.getById(id);
	}
	
	@PostMapping("save")
	public Platform savePlatform( @RequestBody Platform cat ) {
		return platformService.save(cat);
	}
	
	@PutMapping("update")
	public Platform updatePlatform( @RequestBody Platform cat ) {
		return platformService.save(cat);
	}
	
	@DeleteMapping("delete/{id}")
	public ObjectNode deletePlatformById( @PathVariable( name = "id" ) int id ){ 
		return platformService.deleteById(id);
	}

}
