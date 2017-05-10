package com.greenfox.arrayhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.ErrorMessage;
import com.greenfox.logentries.Log;
import com.greenfox.logentries.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ArrayHandlerRestController {
  @Autowired
  LogRepository logRepo;

  @RequestMapping(value = "/arrays")
  public Object arrayHandler(@RequestBody() Input input, HttpServletRequest request) {
    ObjectMapper mapper = new ObjectMapper();
    String body = null;
    try {
      body = mapper.writeValueAsString(input);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    logRepo.save(new Log(request.getRequestURI(), body));
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
