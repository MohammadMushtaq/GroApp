package com.xworkz.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.grocery.service.GroceryService;

@Controller
@RequestMapping("/")
public class GroceryGetAllGroceryController {

	@Autowired
	private GroceryService groceryService;

	public GroceryGetAllGroceryController() {
		System.out.println("invoked get all grocery in controller ");
	}

	@RequestMapping("/getAllGrocery.do")
	public String getAllGrocery(Model model) {
		System.out.println("Invoked getAllGrocery");

		List<Object> list = this.groceryService.getAllGrocery();
		if (list != null && !list.isEmpty()) {
			model.addAttribute("groceryList", list);
			model.addAttribute("message", "Grocery items retrieved successfully.");
		} else {
			model.addAttribute("message", "No grocery items found.");
		}

		return "/GetAll.jsp";
	}
}