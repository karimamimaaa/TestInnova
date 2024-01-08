package com.Inventory.web;

import com.Inventory.Dto.ProductRequestDto;

/*import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.Inventory.Entities.Product;

import com.Inventory.repository.ProductRepository;

@Controller
public class ProductGraphQLController {
	
    //@Autowired 
	private ProductRepository productrepository;
	
	
	public ProductGraphQLController(ProductRepository productrepository)
	   {this.productrepository=productrepository;}


   @QueryMapping
    public List<Product> pruductList()
         {return productrepository.findAll();}
      
   
   @QueryMapping
   public Product productById(@Argument String id)
      {return  productrepository.findById(id).get();}
   
   
      }*/


import com.Inventory.Entities.Category;
import com.Inventory.Entities.Product;
import com.Inventory.repository.CategoryRepository;
import com.Inventory.repository.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.UUID;

@Controller
public class ProductGraphQLController {
	
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductGraphQLController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    
    @QueryMapping
    public List<Product>  productList(){
        return productRepository.findAll();}
    
    //les paramétres il faut les annoter avec l'annotation @Argument 
    //et il faut ajouter cette méthode au schéma Grapheql
    @QueryMapping
    public Product productById(@Argument String id)
    {return productRepository.findById(id).get();}
    
    @QueryMapping
    public List <Category> categories(){
    	return categoryRepository.findAll();}
    
    @QueryMapping
    public Category categoryById(@Argument Long id) {
    	return categoryRepository.findById(id).get();}
    
    @MutationMapping
    public Product saveProduct(@Argument ProductRequestDto product)
    {   Category category=categoryRepository.findById(product.getCategoryId()).get();
    	Product productToSave=new Product();
    	productToSave.setId(UUID.randomUUID().toString());
    	productToSave.setName(product.getName());
    	productToSave.setPrice(product.getPrice());
    	productToSave.setQuantity(product.getQuantity());
    	productToSave.setCategory(category);
    	return productRepository.save(productToSave);}
    
     @MutationMapping  
     public Product updateProduct(@Argument String id,@Argument ProductRequestDto product)
     {
    	 
    	 Category category=categoryRepository.findById(product.getCategoryId()).get();
    	 //Product productToUpdate=productRepository.findById(id).get();
    	 Product productToSave=new Product();
     	productToSave.setId(id);
     	productToSave.setName(product.getName());
     	productToSave.setPrice(product.getPrice());
     	productToSave.setQuantity(product.getQuantity());
     	productToSave.setCategory(category);
     	return productRepository.save(productToSave); 
    	 }
     
     @MutationMapping
    public void deleteProduct(@Argument String id)
    {productRepository.deleteById(id);}
}

   