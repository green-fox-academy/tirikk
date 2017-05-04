package com.greenfox.configuration;

import com.greenfox.service.EmailService;
import com.greenfox.service.MessageService;
import com.greenfox.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

  @Bean
  public MessageService emailService() {
    return new EmailService();
  }

  @Bean
  public MessageService twitterService() {
    return new TwitterService();
  }
}
