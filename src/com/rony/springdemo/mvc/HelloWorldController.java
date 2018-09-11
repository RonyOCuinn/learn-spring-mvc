package com.rony.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.*;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersion2")
    public String letsShoutDude(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String message = "Yo! " + name;
        model.addAttribute("message", message);

        return "helloworld";
    }

    @RequestMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("studentName") String name, Model model){

        name = name.toUpperCase();
        String message = "Heya! " + name;
        model.addAttribute("message", message);
        return "helloworld";
    }
}
