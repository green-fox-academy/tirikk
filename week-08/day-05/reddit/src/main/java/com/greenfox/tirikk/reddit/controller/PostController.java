package com.greenfox.tirikk.reddit.controller;

import com.greenfox.tirikk.reddit.model.ListOfPosts;
import com.greenfox.tirikk.reddit.model.Post;
import com.greenfox.tirikk.reddit.model.User;
import com.greenfox.tirikk.reddit.repository.PostRepository;
import com.greenfox.tirikk.reddit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class PostController {
  @Autowired
  PostRepository postRepo;
  @Autowired
  UserRepository userRepo;
  @Autowired
  ListOfPosts list;

  @RequestMapping(value = "/posts", method = RequestMethod.GET)
  public ListOfPosts list() {
    list.setPosts((List<Post>)postRepo.findAll());
    return list;
  }

  @RequestMapping(value = "/posts", method = RequestMethod.POST)
  public Post post(@RequestBody() Post post, @RequestHeader(value = "owner", required = false) String owner) {
    userRepo.save(new User(owner));
    Post newPost = new Post(post.getTitle(), post.getHref(), userRepo.findOne(owner));
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
    Post downvotedPost = postRepo.findOne(id);
    downvotedPost.downvote();
    postRepo.save(downvotedPost);
    return downvotedPost;
  }
}
