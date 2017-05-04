package com.greenfox.controllers;

import com.greenfox.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {


  @RequestMapping("/Exercise1")
  public String firstEndpoint(Model model) {
    BankAccount simba = new BankAccount("Simba", 2000, "lion");
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
    List<BankAccount> bankAccounts = new ArrayList<>();
    BankAccount account1 = new BankAccount("Zordon", 2000, "lion");
    bankAccounts.add(account1);
    account1.setKing();
    account1.setBadGuy(true);
    BankAccount account2 = new BankAccount("Pumba", 3000, "warthog");
    bankAccounts.add(account2);
    BankAccount account3 = new BankAccount("Timon", 1000, "meerkat");
    bankAccounts.add(account3);
    BankAccount account4 = new BankAccount("Mufasa", 5000, "lion");
    bankAccounts.add(account4);
    model.addAttribute("bankAccounts", bankAccounts);
    return "thirdEndpoint";
  }
}
