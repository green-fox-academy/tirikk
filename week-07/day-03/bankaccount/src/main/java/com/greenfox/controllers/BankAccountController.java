package com.greenfox.controllers;

import com.greenfox.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {
  List<BankAccount> bankAccounts = new ArrayList<>();

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

  @RequestMapping("/Exercise5")
  public String thirdEndpoint(Model model) {
    bankAccounts.add(new BankAccount("Simba", "2000", "lion"));
    bankAccounts.add(new BankAccount("Timon", "1000", "meerkat"));
    bankAccounts.add(new BankAccount("Pumba", "3000", "warthog"));
    bankAccounts.add(new BankAccount("Mufasa", "5000", "lion"));
    model.addAttribute("bankAccounts", bankAccounts);
    return "thirdEndpoint";
  }
}
