package com.blacksmith.nikiti.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(City.class)
public abstract class City_ {

	public static volatile SingularAttribute<City, Province> province;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, String> description;
	public static volatile SingularAttribute<City, Long> id;
	public static volatile SingularAttribute<City, Integer> version;

	public static final String PROVINCE = "province";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

