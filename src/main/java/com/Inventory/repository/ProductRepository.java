package com.Inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inventory.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,String> {

}
