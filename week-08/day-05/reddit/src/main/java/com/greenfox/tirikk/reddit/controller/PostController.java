package com.greenfox.tirikk.reddit.controller;

import com.greenfox.tirikk.reddit.model.Post;
import com.greenfox.tirikk.reddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
  @Autowired
  PostRepository postRepo;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Object list() {
    return postRepo.findAll();
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Post post(@RequestBody() Post post) {
    Post newPost = new Post(post.getTitle(), post.getHref());
    postRepo.save(newPost);
    return newPost;
  }

  @RequestMapping(value = "/{id}/upvote")
}
