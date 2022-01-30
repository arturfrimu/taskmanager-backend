package com.stefanini.taskmanager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tasks")
@JsonIgnoreProperties(value= {"users", "teams"})
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "tasks")
	private List<User> users;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "tasks")
	private List<Team> teams;

	public Task(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public Task() {}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public void addUser(User user) {
		if (users == null) {
			users = new ArrayList<>();
		} 
		users.add(user);
	}
	
	public void addTeam(Team team) {
		if (teams == null) {
			teams = new ArrayList<>();
		} 
		teams.add(team);
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
}
