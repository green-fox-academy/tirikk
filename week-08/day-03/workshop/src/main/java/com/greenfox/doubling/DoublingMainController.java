package com.greenfox.doubling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoublingMainController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }
}
