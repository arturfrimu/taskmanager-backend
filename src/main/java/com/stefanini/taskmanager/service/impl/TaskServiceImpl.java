package com.stefanini.taskmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stefanini.taskmanager.dao.impl.TaskDAOImpl;
import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskDAOImpl taskDAO;
	
	@Autowired
	public TaskServiceImpl(TaskDAOImpl taskDAO) {
		this.taskDAO = taskDAO;	
	}
	
	@Override
	public List<Task> getUserTasks(String userName) {
		return taskDAO.getUserTasks(userName);
	}
	
	@Override
	public List<Task> getTeamTasks(String teamName) {
		return taskDAO.getTeamTasks(teamName);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskDAO.getAll();
	}

	@Override
	public Task getTaskById(long id) {
		return taskDAO.getById(id);
	}
	
	@Override
	public Task createTask(Task task) throws Exception {
		return taskDAO.add(task);
	}

	@Override
	public void deleteTaskByID(Long id) {
		taskDAO.removeById(id);
	}
}