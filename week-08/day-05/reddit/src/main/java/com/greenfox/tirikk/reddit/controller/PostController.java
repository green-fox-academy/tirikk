package com.greenfox.tirikk.reddit.controller;

import com.greenfox.tirikk.reddit.model.Post;
import com.greenfox.tirikk.reddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
  @Autowired
  PostRepository postRepo;

  @RequestMapping(value = "/posts", method = RequestMethod.GET)
  public Object list() {
    return postRepo.findAll();
  }

  @RequestMapping(value = "/posts", method = RequestMethod.POST)
  public Post post(@RequestBody() Post post) {
    Post newPost = new Post(post.getTitle(), post.getHref());
    postRepo.save(newPost);
    return newPost;
  }

  @RequestMapping(value = "/posts/{id}/upvote", method = RequestMethod.PUT)
  public Post upvote(@PathVariable(name = "id") long id) {
    Post upvotedPost = postRepo.findOne(id);
    upvotedPost.upvote();
    postRepo.save(upvotedPost);
    return upvotedPost;
  }

  @RequestMapping(value = "/posts/{id}/downvote", method = RequestMethod.PUT)
  public Post downvote(@PathVariable(name = "id") long id) {
    Post downvotdPost = postRepo.findOne(id);
    downvotdPost.downvote();
    postRepo.save(downvotdPost);
    return downvotdPost;
  }
}
