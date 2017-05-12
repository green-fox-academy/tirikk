package com.greenfox.tirikk.reddit.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListOfPosts {
  List<Post> posts = new ArrayList<>();

  public ListOfPosts() {
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}

