package it.labshop.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import it.labshop.model.Platform;

public interface PlatformService {

	Iterable<Platform> getAll();
	Platform getById( int id );
	Platform save( Platform cat );
	ObjectNode deleteById( int id );
	
}
