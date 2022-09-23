package com.example.appsport.controllers;

import com.example.appsport.MyCache;
import com.example.appsport.entities.User;
import com.example.appsport.services.PageDataService;
import com.example.appsport.services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Configuration




@Controller

public class UserController {
    UserServices userServices;
    User LoggedUser;
    PageDataService pageDataService;
    @Autowired
    public UserController(UserServices userServices, PageDataService pageDataService){
        this.pageDataService = pageDataService;
        this.userServices = userServices;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("siteTitle", pageDataService.getSiteTitle());

        return "register";
    }

    @PostMapping("/register")
    public String handleUserRegistration(User user){
        try {

            this.userServices.createUser(user);
            return "redirect:login?status=signup_success";
        }catch(Exception exception){
            return "redirect:register?status=signup_failed&message=" + exception.getMessage();
        }
    }
    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam(name="status", required = false) String status,
           @RequestParam(name= "message", required = false) String message,
            Model model
    ){
        model.addAttribute("siteTitle", pageDataService.getSiteTitle());
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        System.out.printf("status: "+ status);
        return "login";
    }

    @PostMapping("/login")
    public String handleUserLogin(User user) {
        try {
            LoggedUser = userServices.verifyUser(user);
            MyCache.User = LoggedUser;
            return "redirect:myProfile";

        } catch (Exception exception) {
            return "redirect:login?status=login_failed&Message= " + exception.getMessage();

        }
    }

    @GetMapping("/myProfile")
    public String showMyProfile(
            Model model
    ){
        model.addAttribute("user", LoggedUser);
        return "myProfile";
    }

}
