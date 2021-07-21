package com.blacksmith.nikiti.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.blacksmith.nikiti.model.Province;

/**
 * DAO for Province
 */
@Stateless
public class ProvinceDao {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	public void create(Province entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Province entity = em.find(Province.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Province findById(Long id) {
		return em.find(Province.class, id);
	}

	public Province update(Province entity) {
		return em.merge(entity);
	}

	public List<Province> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Province> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM Province p LEFT JOIN FETCH p.country ORDER BY p.id",
						Province.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
