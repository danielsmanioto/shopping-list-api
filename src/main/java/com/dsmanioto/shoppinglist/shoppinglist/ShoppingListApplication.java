package com.dsmanioto.shoppinglist.shoppinglist;

import com.dsmanioto.shoppinglist.shoppinglist.model.ShoppingList;
import com.dsmanioto.shoppinglist.shoppinglist.repository.ShoppingListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner predefineValues(ShoppingListRepository repository) {
		return (args) -> {
			repository.insert(new ShoppingList("Gravo"));
			repository.insert(new ShoppingList("Sorvete"));
			repository.insert(new ShoppingList("Tempero"));
			repository.insert(new ShoppingList("Sal"));
			repository.insert(new ShoppingList("Mel"));
			repository.insert(new ShoppingList("Melancia"));
			repository.insert(new ShoppingList("Canela"));
			repository.insert(new ShoppingList("Feijão"));
			repository.insert(new ShoppingList("Presunto"));
			repository.insert(new ShoppingList("Leite"));
			repository.insert(new ShoppingList("Açucar"));
		};
	}

}
