package com.greenfox.tirikk.reddit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String title;
  String href;
  int score;
  Timestamp timestamp;

  public Post() {
  }

  public Post(String title, String href) {
    this.title = title;
    this.href = href;
    this.score = 0;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getHref() {
    return href;
  }

  public int getScore() {
    return score;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }
}
