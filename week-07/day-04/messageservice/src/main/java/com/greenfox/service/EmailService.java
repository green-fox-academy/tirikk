package com.greenfox.service;

public class EmailService implements MessageService {

  @Override
  public String sendMessage() {
    return "Email";
  }
}
