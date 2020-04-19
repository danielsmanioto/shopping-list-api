package com.dsmanioto.shoppinglist.shoppinglist.repository;

import com.dsmanioto.shoppinglist.shoppinglist.model.ShoppingList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ShoppingListRepository {
	
	private List<ShoppingList> shoppingLists = new ArrayList<>();
	
	public List<ShoppingList> findAll() {
		return shoppingLists;
	}
	
	public void insert(ShoppingList item) {
		this.shoppingLists.add(item);
	}
	
	public void remove(ShoppingList item) {
		this.shoppingLists.remove(item);
	}
	
	public Optional<ShoppingList> findByName(String nome) {
		return findAll().stream()
				.filter(item -> item.getItem().toUpperCase().contains(nome.toUpperCase()))
				.findFirst();
	}
	
}
