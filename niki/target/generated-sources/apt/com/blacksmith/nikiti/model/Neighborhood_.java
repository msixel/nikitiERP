package com.blacksmith.nikiti.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Neighborhood.class)
public abstract class Neighborhood_ {

	public static volatile SingularAttribute<Neighborhood, City> city;
	public static volatile SingularAttribute<Neighborhood, String> name;
	public static volatile SingularAttribute<Neighborhood, String> description;
	public static volatile SingularAttribute<Neighborhood, Long> id;
	public static volatile SingularAttribute<Neighborhood, Integer> version;

	public static final String CITY = "city";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

