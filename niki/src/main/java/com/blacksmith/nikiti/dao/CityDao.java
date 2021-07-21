package com.blacksmith.nikiti.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.blacksmith.nikiti.model.City;

/**
 * DAO for City
 */
@Stateless
public class CityDao {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	public void create(City entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		City entity = em.find(City.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public City findById(Long id) {
		return em.find(City.class, id);
	}

	public City update(City entity) {
		return em.merge(entity);
	}

	public List<City> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<City> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM City c LEFT JOIN FETCH c.province ORDER BY c.id",
						City.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
