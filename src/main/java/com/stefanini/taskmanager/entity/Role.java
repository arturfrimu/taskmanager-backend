package com.stefanini.taskmanager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="roles")
@JsonIgnoreProperties(value= {"users", "permissions"})
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="roles")
	private List<Permission> permissions = new ArrayList<Permission>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="role")
	private List<User> users;

	public Role(String name) {
		this.name = name;
	}
	
	public Role() {}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setUser(User user) {
		if (users != null) {
			users = new ArrayList<User>();
		}
		if (user != null)
			users.add(user);	
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Permission addPermission(Permission permission) {
		if (this.permissions == null) {
			this.permissions = new ArrayList<Permission>();
		}
		 this.permissions.add(permission);
		 return permission;
	}
	
  public List<SimpleGrantedAuthority> getAuthorities() {
	  List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
	  for(Permission permission: getPermissions()) {
		  authorities.add(new SimpleGrantedAuthority(permission.getName()));
	  }
	  return authorities;
  }

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", permissions=" + permissions + "]";
	}

	public void setId(Long roleId) {
		if(roleId != null) {
			this.id = roleId;
		}
	}
}
