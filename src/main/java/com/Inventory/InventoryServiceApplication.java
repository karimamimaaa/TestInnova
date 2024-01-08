package com.Inventory;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import com.Inventory.Entities.Category;
import com.Inventory.Entities.Product;
import com.Inventory.repository.CategoryRepository;
import com.Inventory.repository.ProductRepository;
import lombok.Builder;


@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CategoryRepository categoryrepository,ProductRepository productrepository)
	{
		return args ->{
			Random random=new Random();
			List.of("computer","printer","smartphone").forEach(cat->
			{Category category=Category.builder().name(cat).build();
			 categoryrepository.save(category);});
		
			categoryrepository.findAll().forEach(category->{
				
				for(int i=0;i<10;i++)
					
				{Product product=Product.builder()
				    .id(UUID.randomUUID().toString())
				    .name("computer"+i)
				    .price(100+Math.random()*50000)
				    .quantity(random.nextInt(100))
				    .category(category)
					.build();
				productrepository.save(product);
					
				}
			});
	            };
	             }
	

}
