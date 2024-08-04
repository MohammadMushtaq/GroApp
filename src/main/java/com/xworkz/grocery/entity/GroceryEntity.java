package com.xworkz.grocery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cosmetic.gro")
@NamedQueries({
		@NamedQuery(name="findByNameAndBrand", query="SELECT gro FROM GroceryEntity gro WHERE gro.name=:name AND gro.brand=:brand"),
		@NamedQuery(name="findByName", query="select gro from GroceryEntity gro where gro.name=:name"),
		@NamedQuery(name="updateByName", query="update GroceryEntity set name=:name, quantity=:quantity, price=:price, type=:type, brand=:brand where name=:name"),
		@NamedQuery(name = "getAllGrocery", query = "From GroceryEntity"),
		@NamedQuery(name = "deleteGrocery", query = "delete from GroceryEntity gro where gro.name = :name")
})
public class GroceryEntity {
	@Id
	@Column(name="g_id")
	private int id;
	@Column(name="g_name")
	private String name;
	@Column(name="g_quantity")
	private int quantity;
	@Column(name="g_price")
	private double price;
	@Column(name="g_type")
	private String type;
	@Column(name="g_brand")
	private String brand;
	@Column(name="g_total")
	private double total;

	public GroceryEntity() {
	}

	public GroceryEntity(String name, int quantity, double price, String type, String brand, double total) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.type = type;
		this.brand = brand;
		this.total=total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
