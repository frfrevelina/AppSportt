package com.example.appsport.controllers;

import com.example.appsport.MyCache;
import com.example.appsport.entities.*;
import com.example.appsport.services.ExerciseService;
import com.example.appsport.services.UserExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Controller
public class IndividualProgramController<ExerciseId> {
    UserExerciseService userExerciseService;
    ExerciseService exerciseService;
    @Autowired
    public IndividualProgramController(
            UserExerciseService userExerciseService,
            ExerciseService exerciseService
    ){
        this.userExerciseService = userExerciseService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/Individual")
    public String showIndividual(Model model) {
        try {
            var userId = MyCache.User.getId();
            var userExercises = this.userExerciseService.GetUserExercises(userId);
            List<ExerciseOutput> exercises = new ArrayList<>();
            //for (var userExercise : userExercises) {
                //var exercise = this.exerciseService.GetExerciseById(userExercise.getExerciseId());


               // String decoded = "";
                //exercises.add(new ExerciseOutput(exercise.getTitle(), exercise.getRepetitions(), exercise.getType(), decoded));
            //}

            model.addAttribute("exercises", exercises);
            model.addAttribute("userId", userId);

            var allExercises = this.GetAllExercises();
            model.addAttribute("allExercises", allExercises);



            //model.addAttribute("exercise", exercise);
            return "Individual";
        }
        catch(Exception e){
            return "redirect:aim?ErrorMessage=" + e.getMessage();
        }
    }
    @PostMapping ("/addIndividualExercises")
    public String handleAddIndividualExercises(UserExercise userExercise) {
        try {

            this.userExerciseService.saveMyProgress(userExercise);
            return "redirect:seeMyProgramm";
        } catch (Exception exception) {
            return "redirect:myProfile?status=failed";
        }
    }
    @GetMapping("/seeMyProgramm")
    public String showSeeMyProgramm(Model model) {
        try {
            var userId = MyCache.User.getId();
            var userExercises = this.userExerciseService.GetUserExercises(userId);
            List<ExerciseOutput> exercises = new ArrayList<>();
            for (var userExercise : userExercises) {
               var exercise = this.exerciseService.GetExerciseById(userExercise.getExerciseId());


                String decoded = "";
                exercises.add(new ExerciseOutput(exercise.getTitle(), exercise.getRepetitions(), exercise.getType(), decoded));
            }

            Object exercise;
            model.addAttribute("userExercises" , userExercises);
            model.addAttribute("exercises" , exercises);

            System.out.println(userExercises);
            System.out.println(exercises);
            return "seeMyProgramm";
        } catch (Exception exception) {
            return "redirect:myProfile?status=user_not_found?message=" + exception.getMessage();
        }
    }



    private List<Exercise> GetAllExercises() throws Exception{
        return this.exerciseService.GetAllExercises();
    }

}
