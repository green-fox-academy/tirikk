package com.greenfox.tirikk.reddit.repository;

import com.greenfox.tirikk.reddit.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
