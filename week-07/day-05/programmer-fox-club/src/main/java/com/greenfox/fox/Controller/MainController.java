package com.greenfox.fox.Controller;

import com.greenfox.fox.Enum.Drink;
import com.greenfox.fox.Enum.Food;
import com.greenfox.fox.Enum.Trick;
import com.greenfox.fox.Fox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
  @Autowired
  private Fox fox;

  @RequestMapping("/")
  public String informationEndpoint(Model model) {
    model.addAttribute("fox", fox);
    return "index";
  }

  @RequestMapping("/nutritionStore")
  public String nutritionEndpoint(Model model) {
    model.addAttribute("fox", fox);
    model.addAttribute("foodList", Food.values());
    model.addAttribute("drinkList", Drink.values());
    return "nutrition";
  }

  @RequestMapping("/trickCenter")
  public String trickEndpoint(Model model) {
    model.addAttribute("fox", fox);
    model.addAttribute("trickList", Trick.values());
    return "tricks";
  }
}
