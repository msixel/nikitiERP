package com.blacksmith.nikiti.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.blacksmith.nikiti.model.Company;

/**
 * DAO for Company
 */
@Stateless
public class CompanyDao {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	public void create(Company entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Company entity = em.find(Company.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Company findById(Long id) {
		return em.find(Company.class, id);
	}

	public Company update(Company entity) {
		return em.merge(entity);
	}

	public List<Company> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Company> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM Company c LEFT JOIN FETCH c.country LEFT JOIN FETCH c.province LEFT JOIN FETCH c.city LEFT JOIN FETCH c.neighborhood LEFT JOIN FETCH c.employees ORDER BY c.id",
						Company.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
