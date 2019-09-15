package com.muhammad.dojo_overflow.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.muhammad.dojo_overflow.modells.Answer;
import com.muhammad.dojo_overflow.modells.Question;
import com.muhammad.dojo_overflow.services.TagQuestionService;

@Controller
public class QuestionController {

	private final TagQuestionService tagQuestionService;

	public QuestionController(TagQuestionService tagQuestionService) {
		this.tagQuestionService = tagQuestionService;
	}
	
	@RequestMapping("/questions")
	public String showAllQuestions(Model model) {
		model.addAttribute("questions" , tagQuestionService.findAllQuestions());
		return "/view/AllQuestion.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("Question") Question question) {
		return "/view/NewQuestion.jsp";
	}
	
	@RequestMapping(value="/questions" , method=RequestMethod.POST)
	public String addQuestion(@Valid @ModelAttribute("Question") Question question , BindingResult bindingResult ,
				@RequestParam("myTags") String tags) {
		if(bindingResult.hasErrors()) {
			return "redirect:/questions";
		}else {
			tagQuestionService.saveAllTags(tags, question);
			return "redirect:/questions";
		}
	}
	
	@RequestMapping("/answers/{questionId}")
	public String showAnswers(Model model , @ModelAttribute("Answer") Answer answer, @PathVariable("questionId") Long id) {
		model.addAttribute("question" , tagQuestionService.findQestionById(id));
		return "/view/Answers.jsp";
	}
	
	@RequestMapping(value="/answers/{questionId}" , method=RequestMethod.POST)
	public String addAnswer(@Valid @ModelAttribute("Answer") Answer answer ,  @PathVariable("questionId") Long id , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/questions";
		}else {
			Question question = tagQuestionService.findQestionById(id);
			answer.setQuestion(question);
			tagQuestionService.saveAnswer(answer);
			return "redirect:/questions";
		}
	}
	
	
	
}
