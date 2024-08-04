package com.xworkz.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.grocery.dto.GroceryDTO;
import com.xworkz.grocery.entity.GroceryEntity;
import com.xworkz.grocery.service.GroceryService;

@Controller
@RequestMapping("/")
public class GroceryController {

	@Autowired
	private GroceryService groceryService;

	public GroceryController() {
		System.out.println("invoked bean");
	}

	@RequestMapping("/add.do")
	public String saveController(GroceryDTO groceryDTO, Model model) {
		System.out.println("invoked save controller method");
		int total = (int) (groceryDTO.getPrice() * groceryDTO.getQuantity());

		GroceryEntity entity = new GroceryEntity(groceryDTO.getName(), groceryDTO.getQuantity(), groceryDTO.getPrice(),
				groceryDTO.getType(), groceryDTO.getBrand(), total);

		boolean save = groceryService.validateAndSave(entity);

		if (save) {
			System.out.println("Grocery is saved");
			model.addAttribute("message", "Grocery is saved successfully");
			model.addAttribute("grocery", groceryDTO);

			double price = groceryDTO.getPrice() * groceryDTO.getQuantity();
			model.addAttribute("totalprice", "Total price : " + price);
		} else {
			System.out.println("Data is not saved");
			model.addAttribute("message", "Grocery not saved: Grocery entity with name:- "+ groceryDTO.getName()+" and brand:- "+groceryDTO.getBrand()+" already exists");
		}
		return "/AddItemResult.jsp";
	}

}
