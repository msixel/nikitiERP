package com.blacksmith.nikiti.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.blacksmith.nikiti.model.Schedule;

/**
 * DAO for Schedule
 */
@Stateless
public class ScheduleDao {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	public void create(Schedule entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Schedule entity = em.find(Schedule.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Schedule findById(Long id) {
		return em.find(Schedule.class, id);
	}

	public Schedule update(Schedule entity) {
		return em.merge(entity);
	}

	public List<Schedule> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Schedule> findAllQuery = em.createQuery(
				"SELECT DISTINCT s FROM Schedule s ORDER BY s.id",
				Schedule.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
