package com.greenfox.controllers;

import com.greenfox.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankAccountController {

  @RequestMapping("/Exercise1")
  public String firstEndpoint(Model model) {
    BankAccount simba = new BankAccount("Simba", "2000", "lion");
    model.addAttribute("bankAccount", simba);
    return "firstEndpoint";
  }

  @RequestMapping("/Exercise4")
  public String secondEndpoint(Model model) {
    model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "secondEndpoint";
  }
}
