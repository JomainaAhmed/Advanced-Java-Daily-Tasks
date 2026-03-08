package com.lpu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //take req and send resp to client (browser)
public class MyController {
	
	@RequestMapping("/hi")
	public String takeReqHi() {
		return "page.jsp";
	}
	
	@RequestMapping("/login")
	public String loginMethod() {
		return "login.jsp";
	}
	
	@RequestMapping("/d1")
	public String sendData(Model model) {
		model.addAttribute("name", "raju");
		model.addAttribute("phone", 888);
		return "display.jsp";
	}
	
	@RequestMapping("/d2")
	public String sendData4(Model model) {
		sendData(model);
		return "display2.jsp";
	}
	
	@RequestMapping("/mv")
	public ModelAndView sendData2(ModelAndView mv) {
		mv.addObject("name", "Iram");
		mv.addObject("phone", 89899);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/iram")
	public ModelAndView sendData3(ModelAndView mv) {
		mv.addObject("name", "Iram");
		mv.addObject("dob", 27102004);
		mv.setViewName("display3.jsp");
		return mv;
	}
	
//	@RequestMapping("/register")
//	public String registerPage() {
//		return "register.jsp";
//	}
//	
//	@RequestMapping("/reg2")
//	public ModelAndView reg2(@ModelAttribute Student s) {
//
//	    ModelAndView mv = new ModelAndView();
//	    mv.addObject("name", s.getName());
//	    mv.addObject("phone", s.getPhone());
//	    mv.addObject("email", s.getEmail());
//	    mv.setViewName("register.jsp");
//
//	    return mv;
//}
//	@RequestMapping("/form")
//	public ModelAndView form(
//	        @RequestParam(value="name", required=false) String name,
//	        @RequestParam(value="phone", required=false) String phone,
//	        @RequestParam(value="email", required=false) String email) {
//
//	    ModelAndView mv = new ModelAndView();
//	    mv.setViewName("form");   // IMPORTANT: no .jsp
//
//	    if (name != null) {
//	        System.out.println(name);
//	        System.out.println(phone);
//	        System.out.println(email);
//
//	        mv.addObject("name", name);
//	        mv.addObject("phone", phone);
//	        mv.addObject("email", email);
//	    }
//
//	    return mv;
//	}
	@RequestMapping("/reg")
	public ModelAndView register(
	        @RequestParam(value = "n") String name,
	        @RequestParam(value = "p") String phone,
	        @RequestParam(value = "e") String email) {

//	    System.out.println(name);
//	    System.out.println(phone);
//	    System.out.println(email);

	    ModelAndView mv = new ModelAndView();
	    mv.addObject("name", name);
	    mv.addObject("phone", phone);
	    mv.addObject("email", email);
	    mv.setViewName("display4.jsp");

	    return mv;
	}
	
	@RequestMapping("/reg2")
	//@ModelAttribute -- you want to bind entire form data to a POJO (JAVA OBJECT)
	public ModelAndView register2(@ModelAttribute Student s) {

	    ModelAndView mv = new ModelAndView();
	    mv.addObject("name", s.getName());
	    mv.addObject("phone", s.getPhone());
	    mv.addObject("email", s.getEmail());
	    mv.setViewName("display4");

	    return mv;
	}
	
	@RequestMapping("/register")
	public String RegisterPage() {
		return "register";
	
		}
	}
