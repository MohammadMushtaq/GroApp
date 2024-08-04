package com.xworkz.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.grocery.service.GroceryService;

@Controller
@RequestMapping("/")
public class GroceryDeleteController {

	@Autowired
	private GroceryService groceryService;

	public GroceryDeleteController() {
		System.out.println("invoked delete controller");
	}

	@RequestMapping("/delete.do")
	public String deleteGrocery(@RequestParam String name, Model model) {
		System.out.println("Invoked deleteGrocery");

		if (name == null || name.trim().isEmpty()) {
			model.addAttribute("message", "Invalid grocery name provided");
			return "/Delete.jsp";
		}

		boolean deleted = this.groceryService.deleteGrocery(name);
		if (deleted) {
			System.out.println("Grocery successfully deleted");
			model.addAttribute("message", "Grocery is deleted");
		} else {
			model.addAttribute("message", "Grocery does not exist");
		}

		return "/Delete.jsp";
	}
}
