package com.muhammad.dojo_overflow.modells;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;





@Entity
@Table(name="questions")
public class Question {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mainQuestion;
	@Column(updatable=false)
	private Calendar createdAt;
	private Calendar updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )     
    private List<Tag> tags;
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	private List<Answer> answers;
	
	public Question() {
		tags = new ArrayList<>();
	}
	
	public void setTag(Tag tag) {
		tags.add(tag);
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswer(List<Answer> answers) {
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMainQuestion() {
		return mainQuestion;
	}
	public void setmainQuestion(String mainQuestion) {
		this.mainQuestion = mainQuestion;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
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
