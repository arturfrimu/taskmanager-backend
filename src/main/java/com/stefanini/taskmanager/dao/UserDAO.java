package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.entity.User;

public interface UserDAO {

	User getUserByUsername(String username);
	
}

