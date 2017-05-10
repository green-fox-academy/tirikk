package com.greenfox.doubling;

import com.greenfox.ErrorMessage;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoublingRestController {

  @RequestMapping(value = "/doubling", method = RequestMethod.GET)
  public DoublingObject doubling(@RequestParam(name = "input") int i) {
    return new DoublingObject(i);
  }

  @ExceptionHandler(Exception.class)
  public ErrorMessage handleAllException(Exception e) {
    return new ErrorMessage("Please provide an input!");
  }
}
