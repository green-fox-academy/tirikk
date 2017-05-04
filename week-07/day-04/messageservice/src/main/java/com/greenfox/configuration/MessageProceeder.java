package com.greenfox.configuration;

import com.greenfox.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProceeder {
//  @Autowired
  private MessageService service;

  @Autowired
  MessageProceeder(MessageService service) {
    this.service = service;
  }

//  @Autowired
  public void setService(MessageService service) {
    this.service = service;
  }

  public void processMessage(String message, String address) {
    System.out.printf("%s Sent to %s with Message= %s\n", service.sendMessage(), address, message);
  }
}
