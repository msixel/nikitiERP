package com.blacksmith.nikiti.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Position.class)
public abstract class Position_ {

	public static volatile SingularAttribute<Position, String> name;
	public static volatile SingularAttribute<Position, String> description;
	public static volatile SingularAttribute<Position, Long> id;
	public static volatile SingularAttribute<Position, Integer> version;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

