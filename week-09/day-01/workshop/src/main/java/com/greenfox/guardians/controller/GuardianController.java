package com.greenfox.guardians.controller;

import com.greenfox.guardians.Repository.FoodRepository;
import com.greenfox.guardians.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuardianController {
  @Autowired
  Cargo cargo;
  @Autowired
  FoodRepository foodRepo;

  @GetMapping("/groot")
  public Object translate(@RequestParam(name = "message") String message) {
    return new Translation(message);
  }

  @RequestMapping(value = "/yondu", method = RequestMethod.GET)
  public Object arrowSpeed(@RequestParam(name = "distance") double distance,
                           @RequestParam(name = "time") double time) {
    if (time == 0) {
      return new ErrorMessage("Division by zero");
    } else {
      return new Arrow(distance, time);
    }
  }

  @RequestMapping(value = "/rocket", method = RequestMethod.GET)
  public Object shipCargo() {
    return cargo;
  }

  @RequestMapping(value = "/rocket/fill", method = RequestMethod.GET)
  public Object cargoFill(@RequestParam(name = "caliber") String caliber,
                          @RequestParam(name = "amount") int amount) {
    Status status = new Status(caliber, amount);
    cargo.addAmmo(caliber, amount);
    status.setShipstatus(cargo.getShipstatus());
    status.setReady(cargo.isReady());
    return status;
  }

  @RequestMapping(value = "/drax", method = RequestMethod.GET)
  public Iterable<Food> getCalorieTable() {
    return foodRepo.findAll();
  }

  @RequestMapping(value = "/drax/add", method = RequestMethod.POST)
  public String addFood(@RequestBody() Food food) {
    foodRepo.save(food);
    return "Ok";
  }

  @RequestMapping(value = "/drax/remove", method = RequestMethod.POST)
  public String removeFood(@RequestParam(name = "food") String food) {
    foodRepo.delete(food);
    return "Ok";
  }

  @RequestMapping(value = "/drax/{food}/edit", method = RequestMethod.POST)
  public String editFood(@PathVariable(name = "food") String food, @RequestParam(name = "amount") int amount) {
    Food toEdit = foodRepo.findOne(food);
    toEdit.setAmount(amount);
    foodRepo.save(toEdit);
    return "Ok";
  }

  @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
  @ExceptionHandler(Exception.class)
  public Object handleAllException(Exception e) {
    return new ErrorMessage("I am Groot!");
  }
}
