package com.stefanini.taskmanager.converter;

import java.util.List;

import org.springframework.stereotype.Component;
import com.stefanini.taskmanager.entity.User;
import com.stefanini.taskmanager.entity.dto.UserDetailsDto;
import com.stefanini.taskmanager.entity.dto.UserDto;
import java.util.stream.Collectors;

@Component
public class UserConverter {
	
	public UserDto userModelToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setUserName(user.getUserName());
		return userDto;
	}
	
	public UserDetailsDto userModelToUserDetailsDto(User user) {
		UserDetailsDto userDetailsDto = new UserDetailsDto();
		userDetailsDto.setStatus(user.getStatus());
		userDetailsDto.setRole(user.getRole());
		userDetailsDto.setTasks(user.getTasks());
		userDetailsDto.setTeams(user.getTeams());
		userDetailsDto.setId(user.getId());
		userDetailsDto.setUserName(user.getUserName());
		userDetailsDto.setFirstName(user.getFirstName());
		userDetailsDto.setLastName(user.getLastName());
		return userDetailsDto;
	}
	
	 public List<UserDto> userModelToUserDto(List<User> users) {
        return users.stream().map(this::userModelToUserDto).collect(Collectors.toList());
    }
}
