package it.labshop.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import it.labshop.model.Game;

public interface GameDao extends CrudRepository<Game, Integer>{

	// Restituisce range prodotti nell'indice indicato
	@Query( value="SELECT * FROM game WHERE id BETWEEN :start AND :end", nativeQuery = true)
	Iterable<Game> findByRange( @Param("start") int start, @Param("end") int end);
	
	// Restituisce range prodotti il cui name inizia con il testo indicato
	@Query( value="SELECT * FROM game WHERE name LIKE :text", nativeQuery = true)
	Iterable<Game> findBySearch( @Param("text") String text);
	
	// Restituisce range prodotti con id categoria / id piattaforma / price forniti
	@Query( value="SELECT * FROM game WHERE "
			+ "( :cat = 0 OR category_id = :cat ) "
			+ "AND ( :plat = 0 OR platform_id = :plat ) "
			+ "AND ( :price = 0 OR price <= :price)", nativeQuery = true)
	Iterable<Game> findByFilter( @Param("cat") int idCat, @Param("plat") int idPlat, @Param("price") float pr );
}
