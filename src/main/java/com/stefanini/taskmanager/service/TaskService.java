package com.stefanini.taskmanager.service;

import java.util.List;
import com.stefanini.taskmanager.entity.Task;

public interface TaskService {
	
	List<Task> getUserTasks(String userName);
	
	List<Task> getTeamTasks(String teamName);
	
	List<Task> getAllTasks();
	
	Task getTaskById(long id);

	Task createTask(Task task) throws Exception;

	void deleteTaskByID(Long id);
}