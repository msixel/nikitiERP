package com.blacksmith.nikiti.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.blacksmith.nikiti.model.Neighborhood;

/**
 * DAO for Neighborhood
 */
@Stateless
public class NeighborhoodDao {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	public void create(Neighborhood entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Neighborhood entity = em.find(Neighborhood.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Neighborhood findById(Long id) {
		return em.find(Neighborhood.class, id);
	}

	public Neighborhood update(Neighborhood entity) {
		return em.merge(entity);
	}

	public List<Neighborhood> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Neighborhood> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT n FROM Neighborhood n LEFT JOIN FETCH n.city ORDER BY n.id",
						Neighborhood.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
