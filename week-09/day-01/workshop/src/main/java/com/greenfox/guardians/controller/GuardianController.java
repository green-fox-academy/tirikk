package com.greenfox.guardians.controller;

import com.greenfox.guardians.model.Arrow;
import com.greenfox.guardians.model.ErrorMessage;
import com.greenfox.guardians.model.Translation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuardianController {

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

  @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
  @ExceptionHandler(Exception.class)
  public Object handleAllException(Exception e) {
    return new ErrorMessage("I am Groot!");
  }
}
