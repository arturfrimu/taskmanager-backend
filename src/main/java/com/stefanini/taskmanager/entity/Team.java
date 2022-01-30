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
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "teams")
@JsonIgnoreProperties(value = {"users", "tasks"})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "teams")
    private List<User> users;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "team_tasks", joinColumns = {@JoinColumn(name = "team_id")}, inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private List<Task> tasks;

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(task);
    }

    public void addUser(User user) {
        System.out.println("ADD USER 1");
        if (users == null) {
            System.out.println("ADD USER 2");
            users = new ArrayList<>();
        }
        if (user != null) {
            System.out.println("ADD USER 3");
            users.add(user);
        }
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + "]";
    }
}
