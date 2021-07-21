package com.blacksmith.nikiti.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Company.class)
public abstract class Company_ {

	public static volatile SingularAttribute<Company, Country> country;
	public static volatile SingularAttribute<Company, City> city;
	public static volatile SingularAttribute<Company, String> postalCode;
	public static volatile SingularAttribute<Company, String> houseNumber;
	public static volatile SingularAttribute<Company, String> description;
	public static volatile SingularAttribute<Company, Integer> version;
	public static volatile SingularAttribute<Company, Province> province;
	public static volatile SingularAttribute<Company, String> street;
	public static volatile SingularAttribute<Company, String> name;
	public static volatile SingularAttribute<Company, String> cellphone;
	public static volatile SingularAttribute<Company, Long> id;
	public static volatile SingularAttribute<Company, String> landline;
	public static volatile SingularAttribute<Company, Neighborhood> neighborhood;
	public static volatile SingularAttribute<Company, String> complement;
	public static volatile SetAttribute<Company, Employee> employees;
	public static volatile SingularAttribute<Company, String> email;

	public static final String COUNTRY = "country";
	public static final String CITY = "city";
	public static final String POSTAL_CODE = "postalCode";
	public static final String HOUSE_NUMBER = "houseNumber";
	public static final String DESCRIPTION = "description";
	public static final String VERSION = "version";
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

