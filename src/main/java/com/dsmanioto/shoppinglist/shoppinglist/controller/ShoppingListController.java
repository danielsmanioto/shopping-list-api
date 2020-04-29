package com.dsmanioto.shoppinglist.shoppinglist.controller;

import com.dsmanioto.shoppinglist.shoppinglist.exception.ShoppingListNotFoundException;
import com.dsmanioto.shoppinglist.shoppinglist.model.ShoppingList;
import com.dsmanioto.shoppinglist.shoppinglist.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/shopping-list")
public class ShoppingListController {
	
	@Autowired
	private ShoppingListRepository repository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ShoppingList> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public ShoppingList findById(@PathVariable	String name) {
		return repository
				.findByName(name)
				.orElseThrow(ShoppingListNotFoundException::new);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void insert(@RequestBody @Valid ShoppingList item) {
		repository.insert(item);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void remove(@RequestBody ShoppingList item) {
		var itemShoppingList = repository.findByName(item.getItem());
		
		if(!itemShoppingList.isPresent()) {
			throw new ShoppingListNotFoundException();
		}
		
		repository.remove(itemShoppingList.get());
	}
	
}
