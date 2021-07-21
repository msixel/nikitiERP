package com.blacksmith.nikiti.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Facility.class)
public abstract class Facility_ {

	public static volatile SingularAttribute<Facility, Country> country;
	public static volatile SingularAttribute<Facility, City> city;
	public static volatile SingularAttribute<Facility, String> postalCode;
	public static volatile SingularAttribute<Facility, String> houseNumber;
	public static volatile SingularAttribute<Facility, String> description;
	public static volatile SingularAttribute<Facility, Integer> version;
	public static volatile SetAttribute<Facility, Company> companies;
	public static volatile SingularAttribute<Facility, Province> province;
	public static volatile SingularAttribute<Facility, String> street;
	public static volatile SingularAttribute<Facility, String> name;
	public static volatile SingularAttribute<Facility, String> cellphone;
	public static volatile SingularAttribute<Facility, Long> id;
	public static volatile SingularAttribute<Facility, String> landline;
	public static volatile SingularAttribute<Facility, Neighborhood> neighborhood;
	public static volatile SingularAttribute<Facility, String> complement;
	public static volatile SetAttribute<Facility, Employee> employees;
	public static volatile SingularAttribute<Facility, String> email;

	public static final String COUNTRY = "country";
	public static final String CITY = "city";
	public static final String POSTAL_CODE = "postalCode";
	public static final String HOUSE_NUMBER = "houseNumber";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";
	public static final String COMPANIES = "companies";
	public static final String PROVINCE = "province";
	public static final String STREET = "street";
	public static final String NAME = "name";
	public static final String CELLPHONE = "cellphone";
	public static final String ID = "id";
	public static final String LANDLINE = "landline";
	public static final String NEIGHBORHOOD = "neighborhood";
	public static final String COMPLEMENT = "complement";
	public static final String EMPLOYEES = "employees";
	public static final String EMAIL = "email";

}

