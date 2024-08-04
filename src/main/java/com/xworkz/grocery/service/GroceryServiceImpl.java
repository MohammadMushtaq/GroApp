package com.xworkz.grocery.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xworkz.grocery.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.xworkz.grocery.dto.GroceryDTO;
import com.xworkz.grocery.entity.GroceryEntity;
import com.xworkz.grocery.repository.GroceryRepository;

import javax.transaction.Transactional;

@Service
public class GroceryServiceImpl implements GroceryService {

	private GroceryRepository groceryRepository;
	private GroceryDTO groceryDTO;

	private PasswordEncoder passwordEncoder;
	public GroceryServiceImpl(GroceryRepository groceryRepository) {
		this.groceryRepository = groceryRepository;
		System.out.println("invoked service");
	}


	@Override
	@Transactional
	public boolean validateAndSave(GroceryEntity groceryEntity) {
		double s;
		boolean valid = false;
		if (groceryEntity.getName() != null) {
			System.out.println("valid name");
			valid = true;
		} else {
			System.out.println("not a valid name");
			return valid;
		}
		if (groceryEntity.getPrice() != 0) {
			System.out.println("price is valid");
			valid = true;
		} else {
			System.out.println("price is null");
			return valid;
		}
		if (groceryEntity.getBrand() != null) {
			System.out.println("valid brand");
			valid = true;
		} else {
			System.out.println("not a valid brand");
			return valid;
		}
		if (groceryEntity.getQuantity() != 0) {
			System.out.println("valid quantity");
			valid = true;
		} else {
			System.out.println("not a valid quantity");
			return valid;
		}
		if (groceryEntity.getType() != null) {
			System.out.println(" valid type");
			valid = true;
		} else {
			System.out.println("not a valid type");
			return valid;
		}

		// Validate fields
		if (groceryEntity.getName() != null && groceryEntity.getPrice() != 0 && groceryEntity.getBrand() != null
				&& groceryEntity.getQuantity() != 0 && groceryEntity.getType() != null) {
			valid = true;
		} else {
			System.out.println("Invalid grocery entity fields");
			return false;
		}

		// Check if entity with same name and brand already exists
		GroceryEntity existingEntity = this.groceryRepository.findByNameAndBrand(groceryEntity.getName(), groceryEntity.getBrand());
		if (existingEntity != null) {
			System.out.println("Grocery entity with name: " + groceryEntity.getName() + " and brand: " + groceryEntity.getBrand() + " already exists");
			return false;
		}

		// Save new entity
		if (valid) {
			this.groceryRepository.save(groceryEntity);
			System.out.println("Valid service detail");
			return true;
		} else {
			System.err.println("Not valid data");
			return false;
		}
	}

	@Override
	@Transactional
	public GroceryDTO validateAndFindByName(String name) {
		boolean valid = false;
		if (name != null) {
			System.out.println("valid name");

		} else {
			System.out.println("not a valid name");
			valid = false;
		}
		if (valid = true) {
			GroceryEntity entity = this.groceryRepository.findByName(name);
			if(entity!=null) {
				GroceryDTO dto = new GroceryDTO();
				BeanUtils.copyProperties(entity, dto);
				return dto;
			}
			else{
				System.out.println("no entity found with name "+name);
			}
		} else {
			System.out.println("not valid data");
			valid = false;
		}
		return GroceryService.super.validateAndFindByName(name);
	}

	@Override
	@Transactional
	public GroceryDTO validateAndUpdateByName(String name, int quantity, double price, String type, String brand) {
		boolean valid = true;

		if (name == null || name.trim().isEmpty()) {
			System.out.println("Invalid name");
			valid = false;
		}

		if (price <= 0) {
			System.out.println("Invalid price");
			valid = false;
		}

		if (brand == null || brand.trim().isEmpty()) {
			System.out.println("Invalid brand");
			valid = false;
		}

		if (quantity <= 0) {
			System.out.println("Invalid quantity");
			valid = false;
		}

		if (type == null || type.trim().isEmpty()) {
			System.out.println("Invalid type");
			valid = false;
		}

		if (valid) {
			GroceryEntity existingEntity = this.groceryRepository.findByName(name);

			if (existingEntity != null) {
				existingEntity.setQuantity(quantity);
				existingEntity.setPrice(price);
				existingEntity.setBrand(brand);
				existingEntity.setType(type);

				this.groceryRepository.updateByName(existingEntity);

				GroceryDTO dto = new GroceryDTO();
				BeanUtils.copyProperties(existingEntity, dto);
				return dto;
			} else {
				System.out.println("No grocery entity found with the name: " + name);
			}
		} else {
			System.err.println("Validation failed. Invalid data.");
		}

		return null;
	}

	@Override
	public List<Object> getAllGrocery() {

		System.out.println("invoked get all grocery in service");

		List<GroceryEntity> groList = this.groceryRepository.getAllGrocery();
		if (groList != null) {
			List<Object> groceryContainer = new ArrayList<Object>(groList);
			Iterator<Object> itr = groceryContainer.iterator();
			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				System.out.println(object);
			}
			return groceryContainer;

		} else {
			System.out.println("no valid get all");
		}

		return GroceryService.super.getAllGrocery();
	}
	@Override
	@Transactional
	public boolean deleteGrocery(String name) {

		System.out.println("Invoked deleteGrocery in service");

		if (name == null || name.trim().isEmpty()) {
			System.out.println("Invalid grocery name provided");
			return false;
		}

		boolean isDeleted = this.groceryRepository.deleteGroceryByName(name);
		if(isDeleted){
			return isDeleted;
		}
		return false;
	}

	public boolean saveUsers(User user) {
		if (groceryRepository.findUsername(user.getUsername()) == null && groceryRepository.findUserByEmail(user.getEmail()) == null) {
			groceryRepository.saveDataUsers(user);
			return true;
		}
		return false;
	}

	public User findUserByUsernames(String username) {
		return groceryRepository.findUsername(username);
	}
}
