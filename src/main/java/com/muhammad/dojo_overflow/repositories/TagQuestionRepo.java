package com.muhammad.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.dojo_overflow.modells.TagQuestion;

@Repository
public interface TagQuestionRepo extends CrudRepository<TagQuestion, Long>{

	public List<TagQuestion> findAll();
}
