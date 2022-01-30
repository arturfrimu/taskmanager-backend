package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.entity.Team;

public interface TeamDAO {
	
	Team getTeamByName(String teamName);
	
}
