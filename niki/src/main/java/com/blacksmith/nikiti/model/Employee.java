package com.blacksmith.nikiti.model;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;
import javax.persistence.Enumerated;
import com.blacksmith.nikiti.model.Gender;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.blacksmith.nikiti.model.Country;
import javax.persistence.ManyToOne;
import com.blacksmith.nikiti.model.Province;
import com.blacksmith.nikiti.model.City;
import com.blacksmith.nikiti.model.Neighborhood;
import com.blacksmith.nikiti.model.Position;
import com.blacksmith.nikiti.model.Schedule;
import com.blacksmith.nikiti.model.Company;
import javax.xml.bind.annotation.XmlRootElement;
import com.github.adminfaces.persistence.model.PersistenceEntity;

@Entity
@XmlRootElement
public class Employee implements Serializable, PersistenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 63, nullable = false)
	private String name;

	@Column
	private String description;

	@Enumerated
	private Gender gender;

	@Column
	@Temporal(TemporalType.DATE)
	private Date birth;

	@Column(length = 15)
	private String landline;

	@Column(length = 15)
	private String cellphone;

	@Column(length = 31)
	private String email;

	@Column(length = 9, nullable = false)
	private String postalCode;

	@Column(length = 127, nullable = false)
	private String street;

	@Column(length = 31, nullable = false)
	private String houseNumber;

	@Column(length = 31, nullable = false)
	private String complement;

	@ManyToOne
	private Country country;

	@ManyToOne
	private Province province;

	@ManyToOne
	private City city;

	@ManyToOne
	private Neighborhood neighborhood;

	@Column(length = 17)
	private String identityNumber;

	@Column(length = 63)
	private String identityIssuer;

	@Column(length = 17)
	private String taxPayerNumber;

	@Column(length = 17)
	private String socialSecurityId;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date admission;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dealStart;

	@Column
	@Temporal(TemporalType.DATE)
	private Date dealEnd;

	@Column(nullable = false)
	private Integer legacySheetId;

	@ManyToOne
	private Position position;

	@ManyToOne
	private Schedule schedule;

	@ManyToOne
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(final Country country) {
		this.country = country;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(final Province province) {
		this.province = province;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(final City city) {
		this.city = city;
	}

	public Neighborhood getNeighborhood() {
		return this.neighborhood;
	}

	public void setNeighborhood(final Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getIdentityIssuer() {
		return identityIssuer;
	}

	public void setIdentityIssuer(String identityIssuer) {
		this.identityIssuer = identityIssuer;
	}

	public String getTaxPayerNumber() {
		return taxPayerNumber;
	}

	public void setTaxPayerNumber(String taxPayerNumber) {
		this.taxPayerNumber = taxPayerNumber;
	}

	public String getSocialSecurityId() {
		return socialSecurityId;
	}

	public void setSocialSecurityId(String socialSecurityId) {
		this.socialSecurityId = socialSecurityId;
	}

	public Date getAdmission() {
		return admission;
	}

	public void setAdmission(Date admission) {
		this.admission = admission;
	}

	public Date getDealStart() {
		return dealStart;
	}

	public void setDealStart(Date dealStart) {
		this.dealStart = dealStart;
	}

	public Date getDealEnd() {
		return dealEnd;
	}

	public void setDealEnd(Date dealEnd) {
		this.dealEnd = dealEnd;
	}

	public Integer getLegacySheetId() {
		return legacySheetId;
	}

	public void setLegacySheetId(Integer legacySheetId) {
		this.legacySheetId = legacySheetId;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (name != null && !name.trim().isEmpty())
			result += ", name: " + name;
		if (description != null && !description.trim().isEmpty())
			result += ", description: " + description;
		if (gender != null)
			result += ", gender: " + gender;
		if (birth != null)
			result += ", birth: " + birth;
		if (landline != null && !landline.trim().isEmpty())
			result += ", landline: " + landline;
		if (cellphone != null && !cellphone.trim().isEmpty())
			result += ", cellphone: " + cellphone;
		if (email != null && !email.trim().isEmpty())
			result += ", email: " + email;
		if (postalCode != null && !postalCode.trim().isEmpty())
			result += ", postalCode: " + postalCode;
		if (street != null && !street.trim().isEmpty())
			result += ", street: " + street;
		if (houseNumber != null && !houseNumber.trim().isEmpty())
			result += ", houseNumber: " + houseNumber;
		if (complement != null && !complement.trim().isEmpty())
			result += ", complement: " + complement;
		if (country != null)
			result += ", country: " + country;
		if (province != null)
			result += ", province: " + province;
		if (city != null)
			result += ", city: " + city;
		if (neighborhood != null)
			result += ", neighborhood: " + neighborhood;
		if (identityNumber != null && !identityNumber.trim().isEmpty())
			result += ", identityNumber: " + identityNumber;
		if (identityIssuer != null && !identityIssuer.trim().isEmpty())
			result += ", identityIssuer: " + identityIssuer;
		if (taxPayerNumber != null && !taxPayerNumber.trim().isEmpty())
			result += ", taxPayerNumber: " + taxPayerNumber;
		if (socialSecurityId != null && !socialSecurityId.trim().isEmpty())
			result += ", socialSecurityId: " + socialSecurityId;
		if (admission != null)
			result += ", admission: " + admission;
		if (dealStart != null)
			result += ", dealStart: " + dealStart;
		if (dealEnd != null)
			result += ", dealEnd: " + dealEnd;
		if (legacySheetId != null)
			result += ", legacySheetId: " + legacySheetId;
		return result;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(final Position position) {
		this.position = position;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(final Schedule schedule) {
		this.schedule = schedule;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(final Company company) {
		this.company = company;
	}
}