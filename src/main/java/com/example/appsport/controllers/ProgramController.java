package com.example.appsport.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@Controller
public class ProgramController {

    @GetMapping("/aim")
    public String showMyAim(){
        return "aim";
    }
    @GetMapping("/looseWeight")
    public String showLoseWeight(){
        return "looseWeight";
    }
    @GetMapping("/bodybuilding")
    public String showBodyBuilding(){
        return "bodybuilding";
    }
    @GetMapping("/stretching")
    public String showStretching(){
        return "stretching";
    }
    @GetMapping("/lwBeginner")
    public String showLwBeginner(){ return "lwBeginner";}
    @GetMapping("/lwMedium")
    public String showLwMedium(){ return "lwMedium";}
    @GetMapping("/lwPro")
    public String showLwPro(){ return "lwPro";}
    @GetMapping("/bbBeginner")
    public String showBbBeginner(){ return "bbBeginner";}
    @GetMapping("/bbMedium")
    public String showBbMedium(){ return "bbMedium";}
    @GetMapping("/bbPro")
    public String showBbPro(){ return "bbPro";}
    @GetMapping("/stBeginner")
    public String showStBeginner(){ return "stBeginner";}
    @GetMapping("/stMedium")
    public String showStMedium(){ return "stMedium";}
    @GetMapping("/stPro")
    public String showStPro(){ return "stPro";}




}
