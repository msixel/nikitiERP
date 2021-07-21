package com.blacksmith.nikiti.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import com.blacksmith.nikiti.model.Facility;

/**
 * 
 */
@Stateless
@Path("/facilities")
public class FacilityEndpoint {
	@PersistenceContext(unitName = "nikitiPU")
	private EntityManager em;

	@POST
	@Consumes("application/json")
	public Response create(Facility entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(FacilityEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") Long id) {
		Facility entity = em.find(Facility.class, id);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("application/json")
	public Response findById(@PathParam("id") Long id) {
		TypedQuery<Facility> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT f FROM Facility f LEFT JOIN FETCH f.country LEFT JOIN FETCH f.province LEFT JOIN FETCH f.city LEFT JOIN FETCH f.neighborhood LEFT JOIN FETCH f.companies LEFT JOIN FETCH f.employees WHERE f.id = :entityId ORDER BY f.id",
						Facility.class);
		findByIdQuery.setParameter("entityId", id);
		Facility entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/json")
	public List<Facility> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
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
		final List<Facility> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Facility entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (id == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Facility.class, id) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
