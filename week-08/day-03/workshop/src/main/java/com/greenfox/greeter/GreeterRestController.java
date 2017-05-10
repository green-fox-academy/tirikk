package com.greenfox.greeter;

import com.greenfox.ErrorMessage;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreeterRestController {

  @RequestMapping(value = "/greeter", method = RequestMethod.GET)
  public Object greeting(@RequestParam(name = "name") String name,
                           @RequestParam(name = "title") String title) {
      return new Greeter(name, title);
  }

  @ExceptionHandler(Exception.class)
  public ErrorMessage handleAllException(Exception e) {
    if (e.getMessage().contains("name")) {
      return new ErrorMessage("Please provide a name!");
    } else if (e.getMessage().contains("title")) {
      return new ErrorMessage("Please provide a title!");
    } else {
      return null;
    }
  }
}
