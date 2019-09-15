package com.muhammad.dojo_overflow.modells;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Answer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mainAnswer;
	@Column(updatable=false)
	private Calendar createdAt;
	private Calendar updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
	private Question question;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMainAnswer() {
		return mainAnswer;
	}
	public void setMainAnswer(String mainAnswer) {
		this.mainAnswer = mainAnswer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	@PrePersist
	protected void onCreate() {
	  createdAt = Calendar.getInstance();
	}
	@PreUpdate
	protected void onUpdate() {
	  updatedAt = Calendar.getInstance();
	}
}
