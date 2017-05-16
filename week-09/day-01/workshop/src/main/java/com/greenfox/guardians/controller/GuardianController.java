package com.greenfox.guardians.controller;

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

  @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
  @ExceptionHandler(Exception.class)
  public Object handleAllException(Exception e) {
    return new ErrorMessage("I am Groot!");
  }
}
