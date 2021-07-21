package com.blacksmith.nikiti.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Province.class)
public abstract class Province_ {

	public static volatile SingularAttribute<Province, Country> country;
	public static volatile SingularAttribute<Province, String> code;
	public static volatile SingularAttribute<Province, String> name;
	public static volatile SingularAttribute<Province, Long> id;
	public static volatile SingularAttribute<Province, Integer> version;

	public static final String COUNTRY = "country";
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

