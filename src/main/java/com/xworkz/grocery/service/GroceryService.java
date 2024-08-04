package com.xworkz.grocery.service;

import java.util.List;

import com.xworkz.grocery.dto.GroceryDTO;
import com.xworkz.grocery.entity.GroceryEntity;
import com.xworkz.grocery.entity.User;

public interface GroceryService {

	boolean validateAndSave(GroceryEntity groceryEntity);

	
	default GroceryDTO validateAndFindByName(String name) {
		return null;

	}

	default GroceryDTO validateAndUpdateByName(String name, int quantity, double price, String type, String brand) {
		return null;
	}

	default GroceryEntity findByNameAndBrand(String name, String brand){
		return null;
	}

	default List<Object> getAllGrocery(){
		return null;
		
	}
	default boolean deleteGrocery(String name) {
		
		return false;
		
	}
	boolean saveUsers(User user);
	User findUserByUsernames(String username);
		
}
