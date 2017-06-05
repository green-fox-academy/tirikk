package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.model.MealStat;
import com.example.demo.model.Response;
import com.example.demo.repository.MealRepository;
import com.example.demo.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MealRestController {
  @Autowired
  private
  MealRepository mealRepo;
  @Autowired
  MealTypeRepository mealTypeRepo;

  @GetMapping("/getmeals")
  public Iterable<Meal> getMeals() {
    return mealRepo.findAll();
  }

  @GetMapping("/getstats")
  public MealStat getStats() {
    int totalCals = 0;
    for (Meal meal : mealRepo.findAll()) {
      totalCals += meal.getCalories();
    }
    return new MealStat(((List)mealRepo.findAll()).size(), totalCals);
  }

  @PostMapping("/meal")
  public Response postMeal(@RequestBody @Valid Meal toSave, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      throw new IllegalArgumentException("There's something wrong!");
    } else {
      mealRepo.save(toSave);
      return new Response("ok");
    }
  }

  @DeleteMapping("/meal")
  public Response deleteMeal(@RequestBody Meal toDelete) {
    mealRepo.delete(toDelete);
    return new Response("ok");
  }

  @ResponseStatus (code = HttpStatus.I_AM_A_TEAPOT)
  @ExceptionHandler(IllegalArgumentException.class)
  public Response handleIllegalArgsException(IllegalArgumentException e) {
    System.out.println("########################### ERROR ################################");
    return new Response("error");
  }
}
