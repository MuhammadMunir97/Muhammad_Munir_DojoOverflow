package com.muhammad.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.dojo_overflow.modells.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long>{

	public List<Tag> findAll();
	public Tag findBySubject(String subject);
}
