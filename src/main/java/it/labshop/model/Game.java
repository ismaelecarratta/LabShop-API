package it.labshop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "game" )
public class Game {

	@Id
	private int id;
	
	@Column( name = "name")
	private String name;

	@Column( name = "description_1")
	private String descr1;
	
	@Column( name = "description_2")
	private String descr2;
	
	@Column( name = "price")
	private float price;

	@ManyToOne( cascade = CascadeType.REFRESH )
	@JoinColumn( name = "category_id", referencedColumnName = "id")
	private Category category;
	
	@ManyToOne( cascade = CascadeType.REFRESH )
	@JoinColumn( name = "platform_id", referencedColumnName = "id")
	private Platform platform;

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescr1() { return descr1; }
	public void setDescr1(String descr1) { this.descr1 = descr1; }
	public String getDescr2() { return descr2; }
	public void setDescr2(String descr2) { this.descr2 = descr2; }
	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
	public Category getCategory() { return category; }
	public void setCategory(Category category) { this.category = category; }
	public Platform getPlatform() { return platform; }
	public void setPlatform(Platform platform) {this.platform = platform; }

}
