//////package com.lpu;
//////
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.stereotype.Controller;
//////import org.springframework.web.bind.annotation.ModelAttribute;
//////import org.springframework.web.bind.annotation.RequestMapping;
//////import org.springframework.web.servlet.ModelAndView;
//////
//////@Controller
//////public class MyController {
//////	
//////	@Autowired
//////	EmployeeDAO dao;
//////	
//////	@RequestMapping("/reg")
//////	//@ModelAttribute -- you want to bind entire form data to a POJO (JAVA OBJECT)
//////	public ModelAndView EmpReg(@ModelAttribute Employee s) {
//////		
//////		EmployeeDAO dao = new EmployeeDAO();
//////		dao.save(s);
//////		
//////	    ModelAndView mv = new ModelAndView();
//////	    mv.addObject("id", s.getId());
//////	    mv.addObject("name", s.getName());
//////	    mv.addObject("phone", s.getPhone());
//////	    mv.addObject("email", s.getEmail());
//////	    mv.setViewName("display");
//////
//////	    return mv;
//////	}
//////	
//////	@RequestMapping("/register")
//////	public String RegisterPage() {
//////		return "EmpReg";
//////	
//////		}
//////	}
////package com.lpu;
////
////import java.util.List;
////
////import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.servlet.ModelAndView;
////
////@Controller
////public class MyController {
////
////    EmployeeDAO dao = new EmployeeDAO();
////
////    // 1️⃣ Show Registration Page
////    @RequestMapping("/register")
////    public String registerPage() {
////        return "EmpReg";   // EmpReg.jsp
////    }
////
////    // 2️⃣ Save Employee
////    @RequestMapping("/save")
////    public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
////
////        dao.save(emp);
////
////        ModelAndView mv = new ModelAndView();
////        mv.setViewName("display");
////        mv.addObject("msg", "Employee Saved Successfully!");
////        mv.addObject("employee", emp);
////
////        return mv;
////    }
////
////    // 3️⃣ Find All Employees
////    @RequestMapping("/findall")
////    public ModelAndView findAllEmployees() {
////
////        List<Employee> list = dao.findAll();
////
////        ModelAndView mv = new ModelAndView();
////        mv.setViewName("displayAll");
////        mv.addObject("employees", list);
////
////        return mv;
////    }
////}
package com.lpu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

//    EmployeeDAO dao = new EmployeeDAO();
//
//    // Show registration page
//    @RequestMapping("/register")
//    public String registerPage() {
//        return "EmpReg";
//    }
//
//    // Save employee
//    @RequestMapping("/save")
//    public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
//
//        dao.save(emp);
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("display");
//        mv.addObject("employee", emp);
//        return mv;
//    }
//
//    // Find all employees
//    @RequestMapping("/findall")
//    public ModelAndView findAllEmployees() {
//
//        List<Employee> list = dao.findAll();
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("displayAll");
//        mv.addObject("employees", list);
//
//        return mv;
//    }
//}

    EmployeeDAO dao = new EmployeeDAO();

    @RequestMapping("/register")
    public String registerPage() {
        return "EmpReg";
    }

    @RequestMapping(value = "/save")
    public ModelAndView saveEmployee(@ModelAttribute Employee emp) {

        dao.save(emp);

        return new ModelAndView("redirect:/findall");
    }

    @RequestMapping("/findall")
    public ModelAndView findAllEmployees() {

        ModelAndView mv = new ModelAndView("displayAll");
        mv.addObject("employees", dao.findAll());
        return mv;
    }

    //delete
    @RequestMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        dao.delete(id);
        return "redirect:/findall";
    }

    //edit page
    @RequestMapping("/edit")
    public ModelAndView editEmployee(@RequestParam("id") int id) {

        Employee emp = dao.findById(id);

        ModelAndView mv = new ModelAndView("editform");
        mv.addObject("employee", emp);
        return mv;
    }

    //update
    @RequestMapping("/update")
    public String updateEmployee(@ModelAttribute Employee emp) {

        dao.update(emp);
        return "redirect:/findall";
    }
}