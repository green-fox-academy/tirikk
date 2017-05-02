package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {
  private AtomicLong a1 = new AtomicLong(1);
  String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
          "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
          "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
          "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};
  String[] colors = {"red", "blue", "yellow", "green", "grey", "crimson", "purple", "pink"};

  @RequestMapping("/web/greeting")
  public String greeting(Model model, @RequestParam("name") String name) {
    List<String> list = Arrays.asList(hellos);
    model.addAttribute("colorLength", colors.length);
    model.addAttribute("color", colors);
    model.addAttribute("hello", list);
    model.addAttribute("id", a1.getAndIncrement());
    model.addAttribute("name", name);
    model.addAttribute("random", (int)(Math.random() * 40));
    return "greeting";
  }
}
