package com.stefanini.taskmanager.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	
	@Column(name="first_name", length = 128)
	private String firstName;

	@Column(name="last_name", length = 128)
	private String lastName;
	
	@Column(name="user_name", length = 64, unique=true)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade={CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH})
	@JoinTable(name="user_tasks", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name = "task_id")})
	private List<Task> tasks;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
	@JoinTable(name="user_teams", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns={@JoinColumn(name="team_id")})
	private List<Team> teams;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	public User(String firstName, String lastName, String userName, String password, List<Task> tasks, Status status, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.tasks = tasks;
		this.status = status;
		this.role = role;
	}

	public User(String firstName, String lastName, String userName, String password, Status status, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	public User(String firstName, String lastName, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}

	public User() {}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public void addTask(Task task) {
        if (tasks == null)
        	tasks = new ArrayList<>();
        if (task != null)
        	tasks.add(task);
    }
	
	public void addTeam(Team team) {
        if (teams == null)
        	teams = new ArrayList<>();
        if (team != null)
        	teams.add(team);
    }

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
