package com.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    UserDao userDAO = new UserDao();

    @RequestMapping("/form")
    public String showForm() {
        return "form.jsp";
    }

    @RequestMapping(value="/submitForm")
    public ModelAndView saveUser(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String email) {

        Users user = new Users();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);

        userDAO.saveUser(user);

        ModelAndView mv = new ModelAndView("result.jsp");
        mv.addObject("id", user.getId());
        mv.addObject("name", name);
        mv.addObject("phone", phone);
        mv.addObject("email", email);

        return mv;
    }

    @RequestMapping("/getUser")
    public ModelAndView getUser(@RequestParam int id) {

        Users user = userDAO.getUserById(id);

        ModelAndView mv = new ModelAndView("result.jsp");

        if(user != null){
            mv.addObject("id", user.getId());
            mv.addObject("name", user.getName());
            mv.addObject("phone", user.getPhone());
            mv.addObject("email", user.getEmail());
        } else {
            mv.addObject("name", "User Not Found");
        }

        return mv;
    }
}
