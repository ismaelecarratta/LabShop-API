package it.labshop.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "category")
public class Category {
	
	@Id
	private int id;
	
	@Column( name = "name" )
	private String name;

	@OneToMany( cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "category", orphanRemoval = true)
	@JsonIgnore
	private List<Game> listGame = new ArrayList<>();


	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name;}
	public void setName(String name) { this.name = name; }
	public List<Game> getListGame() { return listGame; }
	public void setListGame(List<Game> listGame) { this.listGame = listGame; }


}
