package com.stefanini.taskmanager.dao.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.stefanini.taskmanager.dao.TaskDAO;
import com.stefanini.taskmanager.entity.Task;
import com.stefanini.taskmanager.entity.Team;
import com.stefanini.taskmanager.entity.User;

@Repository
public class TaskDAOImpl extends AbstractDAOImpl<Task> implements TaskDAO {
	
	final static Logger log = Logger.getLogger(TaskDAOImpl.class.getName());

	@Override
	public List<Task> getUserTasks(String userName) {
		List<Task> tasks = null;
		try (Session session = getSession()) {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
			Root<User> root = criteriaQuery.from(User.class);
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.equal(root.get("userName"), userName));
			User user = session.createQuery(criteriaQuery).uniqueResult();
			tasks = user.getTasks();
		} catch (Exception e) {
			log.error("Cannot get user tasks", e);
		}
		return tasks;
	}
	
	@Override
	public List<Task> getTeamTasks(String teamName) {
		List<Task> tasks = null;
		try (Session session = getSession()) {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Team> criteriaQuery = criteriaBuilder.createQuery(Team.class);
			Root<Team> root = criteriaQuery.from(Team.class);
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.equal(root.get("name"), teamName));
			Team team = session.createQuery(criteriaQuery).uniqueResult();
			tasks = team.getTasks();
		} catch (Exception e) {
			log.error("Cannot get team tasks", e);
		}
		return tasks;
	}
	
	@Override
	protected Class<Task> getEntityClass() {
		return Task.class;
	}
}