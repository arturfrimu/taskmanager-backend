package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.entity.Team;
import com.stefanini.taskmanager.entity.User;

public interface TeamService {

    Team addUserToTeam(Long teamId, Long userId);

    Team saveTeam(Team team) throws Exception;

    List<Team> getAllTeams();

    Team getTeamByName(String teamName);

    Team getTeamById(long id);

    Team addTaskToTeam(Task task, Long id);

    List<User> getTeamUsers(long id);

    List<Task> getTeamTasks(long id);
}
