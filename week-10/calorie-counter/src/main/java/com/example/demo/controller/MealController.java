package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.model.MealType;
import com.example.demo.repository.MealRepository;
import com.example.demo.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MealController {
  @Autowired
  private
  MealRepository mealRepo;
  @Autowired
  private
  MealTypeRepository mealTypeRepo;

  @GetMapping("/")
  public String main(Model model) {
    model.addAttribute("meals", mealRepo.findAll());
    int totalCals = 0;
    for (Meal meal : mealRepo.findAll()) {
      totalCals += meal.getCalories();
    }
    model.addAttribute("totalCals", totalCals);
    return "index";
  }

  @RequestMapping({"/add", "/add/{id}"})
  public String add(Model model, @PathVariable(name = "id", required = false) Long id) {
    if (id != null) {
      model.addAttribute("mealToEdit", mealRepo.findOne(id));
    }
    model.addAttribute("mealTypes", mealTypeRepo.findAll());
    return "edit";
  }

  @PostMapping({"/edit", "/edit/{id}"})
  public String save(@RequestParam(name = "date") String date, @RequestParam(name = "mealType") MealType mealType,
                     @RequestParam(name = "description") String description, @RequestParam(name = "calories") int
                             calories, @PathVariable(name = "id", required = false) Long id) {
    Meal toSave;
    if (id != null) {
      toSave = mealRepo.findOne(id);
      toSave.setCalories(calories);
      toSave.setDate(date);
      toSave.setDescription(description);
      toSave.setType(mealType);
    } else {
      toSave = new Meal(date, mealType, description, calories);
    }
    mealRepo.save(toSave);
    return "redirect:/";
  }

  @RequestMapping("/delete")
  public String delete(@RequestParam(name = "toDelete") long id) {
    mealRepo.delete(id);
    return "redirect:/";
  }
}
