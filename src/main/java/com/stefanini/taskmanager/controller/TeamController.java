package com.stefanini.taskmanager.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.entity.Team;
import com.stefanini.taskmanager.entity.User;
import com.stefanini.taskmanager.service.impl.TeamServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class TeamController {
    private final TeamServiceImpl teamService;

    public TeamController(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/teams")
    public ResponseEntity<?> getAllTeams() {
        try {
            List<Team> teams = teamService.getAllTeams();
            if (teams == null) {
                return new ResponseEntity<>("Cannot find this team in database", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot get information about teams from server", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/teams/teamName/{teamName}")
    @PreAuthorize("hasAuthority('WRITE')")
    public ResponseEntity<?> getTeamByName(@PathVariable("teamName") String teamName) {
        try {
            return new ResponseEntity<>(teamService.getTeamByName(teamName), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot get information from server about team " + teamName, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/teams/id/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> getTeamById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(teamService.getTeamById(id), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot get information about team with id " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/teams")
    public ResponseEntity<?> addTeam(@RequestBody Team team) {
        try {
            return new ResponseEntity<>(teamService.saveTeam(team), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot create new team in database", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/teams/addTask/{id}")
    public ResponseEntity<?> addTaskToTeam(@PathVariable("id") Long id, @RequestBody Task task) {
        try {
            teamService.addTaskToTeam(task, id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot add task to team", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/teams/addUser/{id}")
    public ResponseEntity<?> addUserToTeam(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            teamService.addUserToTeam(id, user.getId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot add user to team", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/teams/users/{id}")
    public ResponseEntity<?> getTeamUsers(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(teamService.getTeamUsers(id), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot get information from server about team ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/teams/tasks/{id}")
    public ResponseEntity<?> getTeamTasks(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(teamService.getTeamTasks(id), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot get information from server about team ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}