package com.Inventory.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.Inventory.InventoryServiceApplication;
import com.Inventory.Entities.Product.ProductBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder 
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Category {
	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="category")
	List <Product> products;

	/*public Category(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}

	public Category() {
		super();
	} */
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	

}
