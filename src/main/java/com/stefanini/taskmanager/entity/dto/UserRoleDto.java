package com.stefanini.taskmanager.entity.dto;

import com.stefanini.taskmanager.entity.Role;

public class UserRoleDto {
	
	private Long userId;
	private Role role;
	
	public UserRoleDto() {}
	

	public UserRoleDto(Long userId, Role role) {
		this.userId = userId;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "UserRoleDto [userId=" + userId + ", roleId=" + role + "]";
	}
}
