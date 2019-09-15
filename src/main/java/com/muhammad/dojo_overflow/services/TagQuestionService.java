package com.muhammad.dojo_overflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.muhammad.dojo_overflow.modells.Answer;
import com.muhammad.dojo_overflow.modells.Question;
import com.muhammad.dojo_overflow.modells.Tag;
import com.muhammad.dojo_overflow.modells.TagQuestion;
import com.muhammad.dojo_overflow.repositories.AnswerRepo;
import com.muhammad.dojo_overflow.repositories.QuestionRepo;
import com.muhammad.dojo_overflow.repositories.TagQuestionRepo;
import com.muhammad.dojo_overflow.repositories.TagRepo;


@Service
public class TagQuestionService {

	private final QuestionRepo questionRepo;
	private final TagRepo tagRepo;
	private final TagQuestionRepo tagQuestionRepo;
	private final AnswerRepo answerRepo;
	
	public TagQuestionService(QuestionRepo questionRepo, 
								TagRepo tagRepo, 
								TagQuestionRepo tagQuestionRepo,
								AnswerRepo answerRepo) {

		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
		this.tagQuestionRepo = tagQuestionRepo;
		this.answerRepo = answerRepo;
	}
	
	// find all functionality
	public List<Question> findAllQuestions(){
		return questionRepo.findAll();
	}
	
	public List<Tag> findAllTags(){
		return tagRepo.findAll();
	}
	
	public List<TagQuestion> findAllTagQuestion(){
		return tagQuestionRepo.findAll();
	}
	
	public List<Answer> findAllAnswers(){
		return answerRepo.findAll();
	}
	
	// find by id functionality
	
	public Question findQestionById(Long id) {
		Optional<Question> question = questionRepo.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			return null;
		}
	}
	
	public Tag findTagById(Long id) {
		Optional<Tag> tag = tagRepo.findById(id);
		if(tag.isPresent()) {
			return tag.get();
		}else {
			return null;
		}
	}
	
	public TagQuestion findTagQuestionById(Long id) {
		Optional<TagQuestion> tagQuestion = tagQuestionRepo.findById(id);
		if(tagQuestion.isPresent()) {
			return tagQuestion.get();
		}else {
			return null;
		}
		
	}
	
	public Answer findAnswerById(Long id) {
		Optional <Answer> answer = answerRepo.findById(id);
		if(answer.isPresent()) {
			return answer.get();
		}else {
			return null;
		}
	}
	
	// saving all objects
	
	public void saveAnswer(Answer answer) {
		answerRepo.save(answer);
	}
	
	public void saveTag(Tag tag) {
		tagRepo.save(tag);
	}
	
	public void saveTagQuestion(TagQuestion tagQuestion) {
		tagQuestionRepo.save(tagQuestion);
	}
	
	public void saveQuestion(Question question) {
		questionRepo.save(question);
	}
	
	public void saveAllTags(String tags , Question question) {
		questionRepo.save(question);
		List<Tag> myTags = seperateAllTags(tags);
		
		for (int i = 0; i < myTags.size(); i++) {
			Tag existingTag = tagRepo.findBySubject(myTags.get(i).getSubject());
			if(existingTag != null) {
				myTags.remove(i);
				myTags.add(i, existingTag);
			}
			myTags.get(i).setQuestion(question);
		}
		tagRepo.saveAll(myTags);
	}
	
	
	
	public List<Tag> seperateAllTags(String tags){
		tags = tags.toLowerCase();
		String[] allTags = tags.split(",");
		
		List<Tag> myTags = new ArrayList<Tag>();
		for (String singleTag : allTags) {
			singleTag = singleTag.replaceAll("\\s","");
			Tag tag = new Tag();
			tag.setSubject(singleTag);
			myTags.add(tag);
		}
		return myTags;
	}
	
	// delete objects by id
	
	public void deleteAnswerById(Long id) {
		answerRepo.deleteById(id);
	}
	
	public void deleteQuestionById(Long id) {
		questionRepo.deleteById(id);
	}
	
	public void deleteTagQuestionById(Long id) {
		tagQuestionRepo.deleteById(id);
	}
	
	public void deleteTagById(Long id) {
		tagRepo.deleteById(id);
	}
}
