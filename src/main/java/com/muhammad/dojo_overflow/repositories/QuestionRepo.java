package com.muhammad.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.dojo_overflow.modells.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{

	public List<Question> findAll();
}
