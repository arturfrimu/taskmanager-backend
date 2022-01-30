package com.stefanini.taskmanager.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stefanini.taskmanager.dao.RoleDAO;
import com.stefanini.taskmanager.entity.Role;

@Repository
public class RoleDAOImpl extends AbstractDAOImpl<Role> implements RoleDAO {

	@Override
	protected Class<Role> getEntityClass() {
		return Role.class;
	}
	
	@Override
	public Role getRoleByName(String name) {
			Role role = null;
			try (Session session = getSession()) {
				CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
				CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
				Root<Role> root = criteriaQuery.from(Role.class);
				criteriaQuery.select(root);
				criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
				role = session.createQuery(criteriaQuery).uniqueResult();
			} catch (Exception e) {
				log.error(e);
			}
			return role;
		}
}
