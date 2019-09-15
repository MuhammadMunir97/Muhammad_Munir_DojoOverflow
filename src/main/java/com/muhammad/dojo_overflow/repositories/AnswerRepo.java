package com.muhammad.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.dojo_overflow.modells.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer, Long>{

	public List<Answer> findAll();
}
