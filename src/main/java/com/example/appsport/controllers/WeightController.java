package com.example.appsport.controllers;

import com.example.appsport.MyCache;
import com.example.appsport.entities.User;
import com.example.appsport.entities.Weight;
import com.example.appsport.services.PageDataService;
import com.example.appsport.services.WeightService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Configuration
@Controller
public class WeightController {
    WeightService weightService;

    public WeightController(WeightService weightService) {
        this.weightService = weightService;
    }

    @PostMapping("/saveWeight")
    public String handleWeightSaving(Weight weight, Model model) {
        try {
            this.weightService.progress(weight);
            return "redirect:progress";
        } catch (Exception exception) {
            return "redirect:myProfile?status=failed";
        }
    }

    @GetMapping("/progress")
    public String showProgress(Model model) {
        try {
            var userId = MyCache.User.getId();
            var weight = weightService.findByUserId(userId);
            model.addAttribute("weights", weight);
            return "progress";
        } catch (Exception exception) {
            return "redirect:myProfile?status=user_not_found?message=" + exception.getMessage();
        }
    }
}





