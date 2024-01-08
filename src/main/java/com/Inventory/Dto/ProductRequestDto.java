package com.Inventory.Dto;

import lombok.Data;

@Data

public class ProductRequestDto {
	
	
	private String id;
	private String name;
	private double price;
	private int quantity;
    private Long categoryId;

}
