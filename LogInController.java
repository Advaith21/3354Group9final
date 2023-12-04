package com.otm.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogInController {

    @GetMapping("/register")
    public String register() {
    	return "redirect:/register.html";
    }
    
    @GetMapping("/otmpg2")
    public String login() {
        return "redirect:/otmpg2.html";
    }

    @GetMapping("/index")
    public String index() {
    	return "redirect:/index.html";
    }
    
    @GetMapping("/home")
	public String home() {
		return "redirect:/home.html";
	}
	
    @GetMapping("/otmpg4")
	public String forgotPassword() {
		return "redirect:/otmpg4.html";
	}

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user) { 
    	return "redirect:/home.html";
    }
   
}
