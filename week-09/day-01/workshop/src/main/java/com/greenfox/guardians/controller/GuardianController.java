package com.greenfox.guardians.controller;

import com.greenfox.guardians.model.ErrorMessage;
import com.greenfox.guardians.model.Translation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuardianController {


  @RequestMapping(name = "/groot", method = RequestMethod.GET)
  public Object translate(@RequestParam(name = "message") String message) {
    return new Translation(message);
  }

  @ExceptionHandler(Exception.class)
  public Object handleAllException(Exception e) {
    return new ErrorMessage("I am Groot");
  }
}
