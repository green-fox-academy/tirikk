package com.greenfox.controller;

import com.greenfox.model.Todo;
import com.greenfox.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
  @Autowired
  TodoRepository todoRepo;

  @RequestMapping(value = {"/", "/list"})
  public String list(Model model, @RequestParam(name = "isActive", required = false) Boolean isActive) {
    try {
      if (isActive) {
        Iterable<Todo> list = todoRepo.findAll();
        List<Todo> undone = new ArrayList<>();
        for (Todo todo : list) {
          if (!todo.isDone()) {
            undone.add(todo);
          }
        }
        model.addAttribute("todoRepo", undone);
      } else {
        model.addAttribute("todoRepo", todoRepo.findAll());
      }
    } catch (NullPointerException e) {
      model.addAttribute("todoRepo", todoRepo.findAll());
    }
    return "todo";
  }
}
