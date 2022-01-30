package com.stefanini.taskmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="permissions")
public class Permission {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="permission_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
	@JoinTable(name="role_permissions", joinColumns={@JoinColumn(name="permission_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
	private List<Role> roles;

	public Permission(String name, List<Role> roles) {
		this.name = name;
		this.roles = roles;
	}
	
	public Permission(String name) {
		this.name = name;
	}
	
	public Permission() {}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRole() {
		return roles;
	}

	public void setRole(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", roles=" + roles + "]";
	}
}
