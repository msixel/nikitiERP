/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.persistence.service.Service;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.blacksmith.nikiti.model.City;
import javax.enterprise.inject.Produces;
import com.blacksmith.nikiti.model.Company;
import com.blacksmith.nikiti.model.Country;
import com.blacksmith.nikiti.model.Employee;
import com.blacksmith.nikiti.model.Facility;
import com.blacksmith.nikiti.model.Neighborhood;
import com.blacksmith.nikiti.model.Position;
import com.blacksmith.nikiti.model.Province;
import com.blacksmith.nikiti.model.Schedule;

/**
 *
 * Cache for lists used across multiple pages
 */
@Named
@ApplicationScoped
public class AppLists implements Serializable {

	@Inject
	@Service
	private CrudService<City, Long> cityService;
	private Set<City> citys;

	@Inject
	@Service
	private CrudService<Company, Long> companyService;
	private Set<Company> companys;

	@Inject
	@Service
	private CrudService<Country, Long> countryService;
	private Set<Country> countrys;

	@Inject
	@Service
	private CrudService<Employee, Long> employeeService;
	private Set<Employee> employees;

	@Inject
	@Service
	private CrudService<Facility, Long> facilityService;
	private Set<Facility> facilitys;

	@Inject
	@Service
	private CrudService<Neighborhood, Long> neighborhoodService;
	private Set<Neighborhood> neighborhoods;

	@Inject
	@Service
	private CrudService<Position, Long> positionService;
	private Set<Position> positions;

	@Inject
	@Service
	private CrudService<Province, Long> provinceService;
	private Set<Province> provinces;

	@Inject
	@Service
	private CrudService<Schedule, Long> scheduleService;
	private Set<Schedule> schedules;

	@Produces
	@Named("allCitys")
	public Set<City> allCitys() {
		if (citys == null) {
			citys = new HashSet<>(cityService.criteria().getResultList());
		}
		return citys;
	}

	public void clearCitys() {
		citys = null;
	}

	@Produces
	@Named("allCompanys")
	public Set<Company> allCompanys() {
		if (companys == null) {
			companys = new HashSet<>(companyService.criteria().getResultList());
		}
		return companys;
	}

	public void clearCompanys() {
		companys = null;
	}

	@Produces
	@Named("allCountrys")
	public Set<Country> allCountrys() {
		if (countrys == null) {
			countrys = new HashSet<>(countryService.criteria().getResultList());
		}
		return countrys;
	}

	public void clearCountrys() {
		countrys = null;
	}

	@Produces
	@Named("allEmployees")
	public Set<Employee> allEmployees() {
		if (employees == null) {
			employees = new HashSet<>(employeeService.criteria()
					.getResultList());
		}
		return employees;
	}

	public void clearEmployees() {
		employees = null;
	}

	@Produces
	@Named("allFacilitys")
	public Set<Facility> allFacilitys() {
		if (facilitys == null) {
			facilitys = new HashSet<>(facilityService.criteria()
					.getResultList());
		}
		return facilitys;
	}

	public void clearFacilitys() {
		facilitys = null;
	}

	@Produces
	@Named("allNeighborhoods")
	public Set<Neighborhood> allNeighborhoods() {
		if (neighborhoods == null) {
			neighborhoods = new HashSet<>(neighborhoodService.criteria()
					.getResultList());
		}
		return neighborhoods;
	}

	public void clearNeighborhoods() {
		neighborhoods = null;
	}

	@Produces
	@Named("allPositions")
	public Set<Position> allPositions() {
		if (positions == null) {
			positions = new HashSet<>(positionService.criteria()
					.getResultList());
		}
		return positions;
	}

	public void clearPositions() {
		positions = null;
	}

	@Produces
	@Named("allProvinces")
	public Set<Province> allProvinces() {
		if (provinces == null) {
			provinces = new HashSet<>(provinceService.criteria()
					.getResultList());
		}
		return provinces;
	}

	public void clearProvinces() {
		provinces = null;
	}

	@Produces
	@Named("allSchedules")
	public Set<Schedule> allSchedules() {
		if (schedules == null) {
			schedules = new HashSet<>(scheduleService.criteria()
					.getResultList());
		}
		return schedules;
	}

	public void clearSchedules() {
		schedules = null;
	}

}
