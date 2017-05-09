package com.greenfox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String title;
  boolean urgent = false;
  boolean done = false;

  public Todo() {
  }

  public Todo(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }
}
