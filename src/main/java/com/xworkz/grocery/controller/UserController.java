package com.xworkz.grocery.controller;

import com.xworkz.grocery.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

import com.xworkz.grocery.entity.User;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private GroceryService userService;

    @RequestMapping("/login.do")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        User user = userService.findUserByUsernames(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("username", username);
            return "LandingPage.jsp";
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "Login.jsp";
        }
    }

    @RequestMapping("/register.do")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        boolean isRegistered = userService.saveUsers(user);
        if (isRegistered) {
            model.addAttribute("message", "Registration successful, please login");
            return "Login.jsp";
        } else {
            model.addAttribute("message", "Registration failed, username or email already exists");
            return "Register.jsp";
        }
    }
}
