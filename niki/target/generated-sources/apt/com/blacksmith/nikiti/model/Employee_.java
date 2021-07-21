package com.blacksmith.nikiti.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Country> country;
	public static volatile SingularAttribute<Employee, Gender> gender;
	public static volatile SingularAttribute<Employee, City> city;
	public static volatile SingularAttribute<Employee, String> postalCode;
	public static volatile SingularAttribute<Employee, String> identityIssuer;
	public static volatile SingularAttribute<Employee, String> houseNumber;
	public static volatile SingularAttribute<Employee, String> description;
	public static volatile SingularAttribute<Employee, String> socialSecurityId;
	public static volatile SingularAttribute<Employee, Province> province;
	public static volatile SingularAttribute<Employee, String> identityNumber;
	public static volatile SingularAttribute<Employee, String> street;
	public static volatile SingularAttribute<Employee, String> cellphone;
	public static volatile SingularAttribute<Employee, Company> company;
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> complement;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, Date> dealEnd;
	public static volatile SingularAttribute<Employee, Integer> legacySheetId;
	public static volatile SingularAttribute<Employee, Date> birth;
	public static volatile SingularAttribute<Employee, Date> admission;
	public static volatile SingularAttribute<Employee, Integer> version;
	public static volatile SingularAttribute<Employee, Schedule> schedule;
	public static volatile SingularAttribute<Employee, Date> dealStart;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, String> taxPayerNumber;
	public static volatile SingularAttribute<Employee, String> landline;
	public static volatile SingularAttribute<Employee, Neighborhood> neighborhood;
	public static volatile SingularAttribute<Employee, Position> position;

	public static final String COUNTRY = "country";
	public static final String GENDER = "gender";
	public static final String CITY = "city";
	public static final String POSTAL_CODE = "postalCode";
	public static final String IDENTITY_ISSUER = "identityIssuer";
	public static final String HOUSE_NUMBER = "houseNumber";
	public static final String DESCRIPTION = "description";
	public static final String SOCIAL_SECURITY_ID = "socialSecurityId";
	public static final String PROVINCE = "province";
	public static final String IDENTITY_NUMBER = "identityNumber";
	public static final String STREET = "street";
	public static final String CELLPHONE = "cellphone";
	public static final String COMPANY = "company";
	public static final String ID = "id";
	public static final String COMPLEMENT = "complement";
	public static final String EMAIL = "email";
	public static final String DEAL_END = "dealEnd";
	public static final String LEGACY_SHEET_ID = "legacySheetId";
	public static final String BIRTH = "birth";
	public static final String ADMISSION = "admission";
	public static final String VERSION = "version";
	public static final String SCHEDULE = "schedule";
	public static final String DEAL_START = "dealStart";
	public static final String NAME = "name";
	public static final String TAX_PAYER_NUMBER = "taxPayerNumber";
	public static final String LANDLINE = "landline";
	public static final String NEIGHBORHOOD = "neighborhood";
	public static final String POSITION = "position";

}

