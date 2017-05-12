package com.greenfox.tirikk.reddit.repository;

import com.greenfox.tirikk.reddit.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
