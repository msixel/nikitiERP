package com.blacksmith.nikiti.model;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Version;
import com.blacksmith.nikiti.model.Country;
import javax.persistence.ManyToOne;
import com.blacksmith.nikiti.model.Province;
import com.blacksmith.nikiti.model.City;
import com.blacksmith.nikiti.model.Neighborhood;
import com.blacksmith.nikiti.model.Employee;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.xml.bind.annotation.XmlRootElement;
import com.github.adminfaces.persistence.model.PersistenceEntity;

@Entity
@XmlRootElement
public class Company implements Serializable, PersistenceEntity {

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

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Employee> employees = new HashSet<Employee>();

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
		if (!(obj instanceof Company)) {
			return false;
		}
		Company other = (Company) obj;
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
		return result;
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

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(final Set<Employee> employees) {
		this.employees = employees;
	}
}