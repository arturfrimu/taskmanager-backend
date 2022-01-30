package com.stefanini.taskmanager.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stefanini.taskmanager.dao.impl.RoleDAOImpl;
import com.stefanini.taskmanager.dao.impl.UserDAOImpl;
import com.stefanini.taskmanager.entity.Role;
import com.stefanini.taskmanager.entity.User;
import com.stefanini.taskmanager.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	private final RoleDAOImpl roleDAO;
	private final UserDAOImpl userDAO;
	
	public RoleServiceImpl(UserDAOImpl userDAO, RoleDAOImpl roleDAO){
		this.userDAO = userDAO;
		this.roleDAO = roleDAO;
	}
	
	@Override
	public Role getRoleById(Long id) {
		return roleDAO.getById(id);
	}

	@Override
	public Role getRoleByName(String name) {
		return roleDAO.getRoleByName(name);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDAO.getAll();
	}

	@Override
	public User updateRole(Long userId, Role newRole) {
		User user = userDAO.getById(userId);
		Role role = getRoleByName(newRole.getName());
		user.setRole(role);
		return userDAO.update(user);
	}
}
