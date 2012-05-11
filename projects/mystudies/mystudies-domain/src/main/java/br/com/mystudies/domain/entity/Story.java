package br.com.mystudies.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.mystudies.domain.enun.Priority;
import br.com.mystudies.domain.enun.Status;

/**
 * @author Robson
 */
@Entity
@Table(name="STORY")
public class Story implements EntityBase{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="TITLE")
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(name="PRIORITY")
	private Priority priority;

	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;

	@Column(name="CREATION_DATE")
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name="THEME_ID")
	private Theme theme;
	
	@ManyToOne
	@JoinColumn(name="SPRINT_ID")
	private Sprint sprint;
	

	@Transient // FIXME: future implemenation
	private List<Comment> comments;

	
	public Story() {
	}
	
	
	public Story(String title, Priority priority, Status status,
			Date criationDate) {
		super();
		this.title = title;
		this.priority = priority;
		this.status = status;
		this.creationDate = criationDate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Priority getPriority() {
		return priority;
	}


	public void setPriority(Priority priority) {
		this.priority = priority;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Theme getTheme() {
		return theme;
	}


	public void setTheme(Theme theme) {
		this.theme = theme;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

						
}
