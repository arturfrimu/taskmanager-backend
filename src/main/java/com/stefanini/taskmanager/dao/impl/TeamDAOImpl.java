package com.stefanini.taskmanager.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.stefanini.taskmanager.dao.TeamDAO;
import com.stefanini.taskmanager.entity.Team;

@Repository
public class TeamDAOImpl extends AbstractDAOImpl<Team> implements TeamDAO {
	
	final static Logger log = Logger.getLogger(TeamDAOImpl.class.getName());

	@Override
	public Team getTeamByName(String teamName) {
		Team team = null;
		try (Session session = getSession()) {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Team> criteriaQuery = criteriaBuilder.createQuery(Team.class);
			Root<Team> root = criteriaQuery.from(Team.class);
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.equal(root.get("name"), teamName));
			team = session.createQuery(criteriaQuery).uniqueResult();
		} catch (Exception e) {
			log.error("Cannot get team information", e);
		}
		return team;
	}
	
	@Override
	protected Class<Team> getEntityClass() {
		return Team.class;
	}
}