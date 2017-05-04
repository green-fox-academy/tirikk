package com.greenfox;
import com.greenfox.colors.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
  @Bean
  public HelloWorld helloWorld() {
    return new HelloWorld();
  }

  @Bean
  public MyColor redColor() {
    return new RedColor();
  }

  @Bean
  public MyColor blueColor() {
    return new BlueColor();
  }

}
