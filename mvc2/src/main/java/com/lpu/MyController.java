package com.lpu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //take req and send resp to client (browser)
public class MyController {
	
	@RequestMapping("/vs")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/home")
	public String takeReqHi() {
		return "page.jsp";
	}
	
	@RequestMapping("/login")
	public String loginMethod() {
		return "login.jsp";
	}
	
	@RequestMapping("/register")
	public String RegisterMethod() {
		return "register.jsp";
	}
	
}
