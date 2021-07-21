package com.blacksmith.nikiti.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.blacksmith.nikiti.model.Position;

/**
 * DAO for Position
 */
@Stateless
public class PositionDao {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	public void create(Position entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Position entity = em.find(Position.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Position findById(Long id) {
		return em.find(Position.class, id);
	}

	public Position update(Position entity) {
		return em.merge(entity);
	}

	public List<Position> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Position> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Position p ORDER BY p.id",
				Position.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
