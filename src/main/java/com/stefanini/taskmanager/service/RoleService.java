package com.stefanini.taskmanager.service;

import java.util.List;

import com.stefanini.taskmanager.entity.Role;
import com.stefanini.taskmanager.entity.User;

public interface RoleService {
	
	public List<Role> getAllRoles();
	
	public Role getRoleByName(String name);
	
	public Role getRoleById(Long id);

	User updateRole(Long userId, Role newRole);
}
