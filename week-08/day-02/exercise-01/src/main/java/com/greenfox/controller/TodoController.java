package com.greenfox.controller;

import com.greenfox.model.Todo;
import com.greenfox.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

  @RequestMapping("/add")
  public String add(@RequestParam(name = "new_todo") String new_todo) {
    todoRepo.save(new Todo(new_todo));
    return "redirect:/todo/";
  }

  @RequestMapping("/delete")
  public String delete(@RequestParam(name = "toDelete") Todo toDelete) {
    todoRepo.delete(toDelete);
    return "redirect:/todo/";
  }

  @RequestMapping("/edit")
  public String edit(Model model, @RequestParam(name = "id") long id) {
    model.addAttribute("todo", getTodo(id));
    return "edit";
  }

  @RequestMapping("/{id}/change")
  public String save(@PathVariable(name = "id") String id,
                     @RequestParam(name = "title") String title,
                     @RequestParam(name = "urgent", required = false) String urgent,
                     @RequestParam(name = "done", required = false) String done) {
    Todo toChange = todoRepo.findOne(Long.valueOf(id));
    toChange.setTitle(title);
    toChange.setDone(done != null);
    toChange.setUrgent(urgent != null);
    todoRepo.save(toChange);
    return "redirect:/todo/";
  }

  Todo getTodo(long i) {
    Iterable<Todo> list = todoRepo.findAll();
    Todo want = new Todo();
    for (Todo todo : list) {
      if (todo.getId() == i) {
        want = todo;
      }
    }
    return want;
  }
}
