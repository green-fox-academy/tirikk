package com.greenfox.guardians.Repository;

import com.greenfox.guardians.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, String> {
}
