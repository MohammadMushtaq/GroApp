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
public class GrocerySearchController {

	@Autowired
	private GroceryService groceryService;
	
	public GrocerySearchController() {
		System.out.println("invoked search");
	}
	
	@RequestMapping("/search.do")
	public String searchName(@RequestParam String name,Model model) {

		if (name == null || name.trim().isEmpty()) {
			model.addAttribute("message", "Invalid grocery name provided");
			return "/SearchItem.jsp";
		}
		
		GroceryDTO dto= this.groceryService.validateAndFindByName(name);
		
		if(dto!=null&&dto.getName().equals(dto.getName())) {
			model.addAttribute("grocery", dto);
			double total=(dto.getQuantity()*dto.getPrice());
			model.addAttribute("totalprice", "Total price :  "+total);
		
		}else {
			model.addAttribute("message", "grocery not found");
			
		}
		return "/SearchItem.jsp";
}
}
