package com.blacksmith.nikiti.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.blacksmith.nikiti.model.Facility;

/**
 * DAO for Facility
 */
@Stateless
public class FacilityDao {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	public void create(Facility entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Facility entity = em.find(Facility.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Facility findById(Long id) {
		return em.find(Facility.class, id);
	}

	public Facility update(Facility entity) {
		return em.merge(entity);
	}

	public List<Facility> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Facility> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT f FROM Facility f LEFT JOIN FETCH f.country LEFT JOIN FETCH f.province LEFT JOIN FETCH f.city LEFT JOIN FETCH f.neighborhood LEFT JOIN FETCH f.companies LEFT JOIN FETCH f.employees ORDER BY f.id",
						Facility.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
