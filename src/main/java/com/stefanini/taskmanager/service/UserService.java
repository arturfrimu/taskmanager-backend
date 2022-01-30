package com.stefanini.taskmanager.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.entity.User;
import com.stefanini.taskmanager.entity.dto.UserDetailsDto;
import com.stefanini.taskmanager.entity.dto.UserDto;

public interface UserService extends UserDetailsService {
	
	User saveUser(User user) throws Exception;

	List<UserDto> getAllUsers();
	
	User getUserByUsername(String username);
	
	UserDto getUserById(Long id);

	UserDetailsDto getUserDetailsById(Long id) throws Exception;

    User addUserToTeam(User userInfo, String teamName);

    void deleteUserByUsername(String username);

	void deleteUserByID(Long id);

	User updateUserById(User userInfo);

	User addTaskToUser(Task task, long id);

}
