package com.example.finaltypeb;

import com.example.finaltypeb.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer> {
}