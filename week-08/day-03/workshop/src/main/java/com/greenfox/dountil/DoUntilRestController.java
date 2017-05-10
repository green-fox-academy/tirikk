package com.greenfox.dountil;

import com.greenfox.ErrorMessage;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoUntilRestController {

  @RequestMapping(value = "/dountil/{what}", method = RequestMethod.POST)
  public Object dountil(@PathVariable(name = "what") String what,
                        @RequestBody() DoUntil dountil) {
    if (what.equals("sum")) {
      return new Sum(dountil.until);
    } else if (what.equals("factor")) {
      return new Factor(dountil.until);
    } else {
      return null;
    }
  }

  @ExceptionHandler(Exception.class)
  public ErrorMessage handleAllException(Exception e) {
    return new ErrorMessage("Please provide a number!");
  }
}
