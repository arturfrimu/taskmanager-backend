package com.stefanini.taskmanager.service.impl;

import java.util.List;

import com.stefanini.taskmanager.entity.Role;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.taskmanager.dao.impl.TeamDAOImpl;
import com.stefanini.taskmanager.dao.impl.UserDAOImpl;
import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.entity.Team;
import com.stefanini.taskmanager.entity.User;
import com.stefanini.taskmanager.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    final static Logger log = Logger.getLogger(TeamServiceImpl.class.getName());

    private final TeamDAOImpl teamDAO;
    private final UserDAOImpl userDAO;

    public TeamServiceImpl(TeamDAOImpl teamDAO, UserDAOImpl userDAO) {
        this.teamDAO = teamDAO;
        this.userDAO = userDAO;
    }

    @Override
    public Team addTaskToTeam(Task task, Long id) {
        Team team = teamDAO.getById(id);
        team.addTask(task);
        return teamDAO.update(team);
    }

    @Override
    public List<User> getTeamUsers(long id) {
        Team team = teamDAO.getById(id);
        return team.getUsers();
    }

    @Override
    public List<Task> getTeamTasks(long id) {
        Team team = teamDAO.getById(id);
        return team.getTasks();
    }

    @Override
    public Team addUserToTeam(Long teamId, Long userId) {
        User user = userDAO.getById(5L);
        Team team = teamDAO.getById(1L);
        team.addUser(user);
        return teamDAO.update(team);
    }

    @Override
    public Team saveTeam(Team team) throws Exception {
        return teamDAO.add(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamDAO.getAll();
    }

    @Override
    public Team getTeamByName(String teamName) {
        return teamDAO.getTeamByName(teamName);
    }

    @Override
    public Team getTeamById(long id) {
        return teamDAO.getById(id);
    }

}