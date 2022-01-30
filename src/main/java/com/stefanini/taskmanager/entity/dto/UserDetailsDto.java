package com.stefanini.taskmanager.entity.dto;

import java.util.List;

import com.stefanini.taskmanager.entity.Role;
import com.stefanini.taskmanager.entity.Status;
import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.entity.Team;

public class UserDetailsDto {
    private Status status;
    private Role role;
    private List<Task> tasks;
    private List<Team> teams;
    private String userName;
    private String firstName;
    private String lastName;
    private long id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserDetailsDto{" +
                "status=" + status +
                ", role=" + role +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
