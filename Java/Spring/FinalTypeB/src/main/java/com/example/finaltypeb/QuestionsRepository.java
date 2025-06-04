package com.example.finaltypeb;

import com.example.finaltypeb.model.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionsRepository extends CrudRepository<Questions, Integer> {
}
