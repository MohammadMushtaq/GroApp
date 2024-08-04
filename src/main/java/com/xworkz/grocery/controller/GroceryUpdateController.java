package com.xworkz.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.grocery.dto.GroceryDTO;
import com.xworkz.grocery.service.GroceryService;

@Controller
@RequestMapping("/")
public class GroceryUpdateController {

	@Autowired
	private GroceryService groceryService;

	public GroceryUpdateController() {
		System.out.println("invoked update");
	}

//String name, int quantity, double price, String type, String brand,double total
	@RequestMapping("/update.do")
	public String ScanAndUpdate(@RequestParam String name, @RequestParam int quantity, @RequestParam double price,
			@RequestParam String type, @RequestParam String brand, Model model) 
	{
		System.out.println("invoked update controller method");
		
		GroceryDTO dto = this.groceryService.validateAndUpdateByName(name, quantity, price, type, brand);
	
		
		if (dto!=null) {
			model.addAttribute("message"," Grocery item updated successfully.");
			model.addAttribute("grocery",dto);
			double tPrice = dto.getPrice() * dto.getQuantity();
			model.addAttribute("totalprice", "total price : " + tPrice);

		} else {
			model.addAttribute("message", "No grocery entity found with the name: " + name);
		}

		return "/UpdateItem.jsp";
	}

}
