package com.stefanini.taskmanager.dao.impl;

import com.stefanini.taskmanager.dao.UserDAO;
import com.stefanini.taskmanager.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {
	
	final static Logger log = Logger.getLogger(AbstractDAOImpl.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String username) {
		User user = null;
		try (Session session = getSession()) {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
			Root<User> root = criteriaQuery.from(getEntityClass());
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.equal(root.get("userName"), username));
			user = session.createQuery(criteriaQuery).uniqueResult();
		} catch (Exception e) {
			log.error(e);
		}
		return user;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class getEntityClass() {
		return User.class;
	}

}
