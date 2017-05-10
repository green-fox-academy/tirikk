package com.greenfox.logentries;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Log {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String createdAt;
  String endpoint;
  String data;

  public Log() {
  }

  public Log(String endpoint, String data) {
    createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    this.endpoint = endpoint;
    this.data = data;
  }

  public long getId() {
    return id;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getData() {
    return data;
  }
}
