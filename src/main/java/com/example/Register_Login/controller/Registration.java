package com.example.Register_Login.controller;

import com.example.Register_Login.model.Person;
import com.example.Register_Login.repositories.PersonRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class Registration {
    @Autowired
    PersonRepositories personRepositories;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public  String home()
    {
        return "register";
    }
    @PostMapping("/handle-register")
    public  String Handle(@ModelAttribute Person person , Model model , BindingResult result)
    {
        if(result.hasErrors())
        {
            model.addAttribute("error",result);
            throw  new RuntimeException("Error occured while registration: " +result);
        }
        person.setPassword(passwordEncoder.encode(person.getPassword()));
       Person res = personRepositories.save(person);
       System.out.println(res);
       return "Login";
    }
    @ResponseBody
    @GetMapping("/")
    public  String goHome()
    {
        return "This is home";
    }

    @GetMapping("/login")
    public  String goLogin()
    {
        return "Login";
    }
}
