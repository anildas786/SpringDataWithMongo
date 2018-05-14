package com.example.demo;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@SpringBootApplication
public class SpringDataWithMongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataWithMongoApplication.class, args);
	}
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(String... args0) throws Exception {
		
		SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		for ( Product product: productRepository.findAll()) {
			
			System.out.println("Product ID : " + product.getId());
			System.out.println("Product Name : " + product.getName());
			System.out.println("Product Price : " + product.getPrice());
			System.out.println("Product Quantity : " + product.getQuantity());
			System.out.println("Product Status : " + product.isStatus());
			System.out.println("Product Date : " + date.format(product.getDate()));
			System.out.println("*************************");
			
		}
		
	}

}
