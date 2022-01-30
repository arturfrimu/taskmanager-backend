package com.stefanini.taskmanager.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.service.impl.TaskServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getAllTasks() {
        try {
            return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot receive list of tasks from server", HttpStatus.OK);
        }
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            return new ResponseEntity<>(taskService.createTask(task), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot create new task in database", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/tasks/delete/id/{id}")
    @PreAuthorize("hasAuthority('WRITE')")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long id) {
        try {
            taskService.deleteTaskByID(id);
            return new ResponseEntity<>("Task was deleted successfully", HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Task can't be deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tasks/id/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> getTaskById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot create new task in database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tasks/userName")
    public ResponseEntity<?> getUserTasks(String userName) {
        try {
            List<Task> userTasks = taskService.getUserTasks(userName);
            if (userTasks == null) {
                return new ResponseEntity<>("User don't have any tasks to work on", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(userTasks, HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot get information about user tasks from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tasks/teamName")
    @PreAuthorize("hasAuthority('READ')")
    public ResponseEntity<?> getTeamTasks(String teamName) {
        try {
            List<Task> teamTasks = taskService.getUserTasks(teamName);
            if (teamTasks == null) {
                return new ResponseEntity<>("Team don't have any tasks to work on", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(teamTasks, HttpStatus.OK);
        } catch (HibernateException e) {
            return new ResponseEntity<>("Cannot get information about team tasks from database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
