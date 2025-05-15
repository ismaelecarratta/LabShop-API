package it.labshop.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.dao.PlatformDao;
import it.labshop.helpers.ResponseManager;
import it.labshop.model.Platform;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PlatformServiceImp implements PlatformService{

	@Autowired PlatformDao platformDao;
	
	@Override
	public Iterable<Platform> getAll() {
		return platformDao.findAll();
	}

	@Override
	public Platform getById(int id) {
		Optional<Platform> plat = platformDao.findById(id);
		if( plat.isPresent() ) { return plat.get(); }
		else{ throw new EntityNotFoundException("Piattaforma non trovata"); }
	}

	@Override
	public Platform save(Platform plat) {
		platformDao.save(plat);
		return plat;
	}

	@Override
	public ObjectNode deleteById(int id) {
		Optional<Platform> plat = platformDao.findById(id);
		
		if( plat.isPresent() ) { 
			platformDao.deleteById(id);
			return new ResponseManager(200, "Piattaforma eliminata").getResponse();
		}
		else { return new ResponseManager(404, "Piattaforma non trovata").getResponse();  }
	}

}
