package com.stefanini.taskmanager.dao;

import java.util.List;
import com.stefanini.taskmanager.entity.Task;

public interface TaskDAO {
	
	List<Task> getUserTasks(String userName);
	
	List<Task> getTeamTasks(String teamName);
	
}