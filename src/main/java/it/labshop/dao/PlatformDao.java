package it.labshop.dao;

import org.springframework.data.repository.CrudRepository;
import it.labshop.model.Platform;

public interface PlatformDao extends CrudRepository<Platform, Integer> {

}
