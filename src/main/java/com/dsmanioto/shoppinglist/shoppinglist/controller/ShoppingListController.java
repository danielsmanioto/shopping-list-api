package com.dsmanioto.shoppinglist.shoppinglist.controller;

import com.dsmanioto.shoppinglist.shoppinglist.model.ShoppingList;
import com.dsmanioto.shoppinglist.shoppinglist.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/shopping-list")
public class ShoppingListController {
	
	@Autowired
	private ShoppingListRepository repository;
	
	@GetMapping
	public List<ShoppingList> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> findById(@PathVariable	String name) {
		var  item = repository.findByName(name);
		
		if(!item.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(item.get());
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ShoppingList item) {
		
		if(Objects.isNull(item) || StringUtils.isEmpty(item.getItem()) ) {
			return ResponseEntity.noContent().build();
		}
		
		repository.insert(item);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity remove(@RequestBody ShoppingList item) {
		if(Objects.isNull(item) || StringUtils.isEmpty(item.getItem()) ) {
			return ResponseEntity.noContent().build();
		}
		var itemShoppingList = repository.findByName(item.getItem());
		
		if(!itemShoppingList.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		repository.remove(itemShoppingList.get());
		 return ResponseEntity.ok().build();
	}
	
}
