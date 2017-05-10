package com.greenfox.arrayhandler;

import com.greenfox.ErrorMessage;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArrayHandlerRestController {

  @RequestMapping(value = "/arrays", method = RequestMethod.POST)
  public Object arrayHandler(@RequestBody() Input input) {
    if (input.what.equals("sum")) {
      return new SumArray(input.numbers);
    } else if (input.what.equals("multiply")) {
      return new Multiplication(input.numbers);
    } else if (input.what.equals("double")) {
      return new Double(input.numbers);
    } else {
      return new ErrorMessage("Please provide what to do with the numbers!");
    }
  }

  @ExceptionHandler(Exception.class)
  public ErrorMessage handleAllException(Exception e) {
    return new ErrorMessage("Please provide what to do with the numbers!");
  }
}
