package com.example.finaltypeb;

import com.example.finaltypeb.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
