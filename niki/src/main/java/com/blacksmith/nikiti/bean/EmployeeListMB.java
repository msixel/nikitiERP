package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.github.adminfaces.persistence.util.Messages;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import com.blacksmith.nikiti.model.Employee;
import com.blacksmith.nikiti.service.EmployeeService;

import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.*;
import org.primefaces.PrimeFaces;
import com.blacksmith.nikiti.model.Country;      
import com.blacksmith.nikiti.model.Province;      
import com.blacksmith.nikiti.model.City;      
import com.blacksmith.nikiti.model.Neighborhood;      
import com.blacksmith.nikiti.model.Position;      
import com.blacksmith.nikiti.model.Schedule;      
import com.blacksmith.nikiti.model.Company;      

@Named
@ViewScoped
public class EmployeeListMB extends CrudMB<Employee> implements Serializable {

    @Inject
    EmployeeService employeeService;

    @Inject
    public void initService() {
        setCrudService(employeeService);
    }

    public void delete() {
        int deletedEntities = 0;
        for (Employee selected : selectionList) {
        	deletedEntities++;
        	employeeService.remove(selected);
        }
        selectionList.clear();
        addDetailMessage(deletedEntities + " employee(s) deleted successfully!");
        clear();
    }

    /**
     * Used in datatable footer to display current search criteria
     */
    public String getSearchCriteria() {
        StringBuilder sb = new StringBuilder(21);
        Employee employeeFilter = filter.getEntity();
 
        Long id = null;
        if (filter.hasParam("id")) {
            id = filter.getLongParam("id");
        } else if (has(employeeFilter.getId())) {
            id = employeeFilter.getId();
        }
        if (has(id)) {
  
	        sb.append("<b>id</b>: ").append(id).append(", ");
        }
 
        String name = null;
        if (filter.hasParam("name")) {
            name = (String)filter.getParam("name");
        } else if (has(employeeFilter.getName())) {
            name = employeeFilter.getName();
        }
        if (has(name)) {
  
	        sb.append("<b>name</b>: ").append(name).append(", ");
        }
 
        String description = null;
        if (filter.hasParam("description")) {
            description = (String)filter.getParam("description");
        } else if (has(employeeFilter.getDescription())) {
            description = employeeFilter.getDescription();
        }
        if (has(description)) {
  
	        sb.append("<b>description</b>: ").append(description).append(", ");
        }
 
        Date birth = null;
        if (filter.hasParam("birth")) {
            birth = (Date)filter.getParam("birth");
        } else if (has(employeeFilter.getBirth())) {
            birth = employeeFilter.getBirth();
        }
        if (has(birth)) {
  
	        sb.append("<b>birth</b>: ").append(birth).append(", ");
        }
 
        String landline = null;
        if (filter.hasParam("landline")) {
            landline = (String)filter.getParam("landline");
        } else if (has(employeeFilter.getLandline())) {
            landline = employeeFilter.getLandline();
        }
        if (has(landline)) {
  
	        sb.append("<b>landline</b>: ").append(landline).append(", ");
        }
 
        String cellphone = null;
        if (filter.hasParam("cellphone")) {
            cellphone = (String)filter.getParam("cellphone");
        } else if (has(employeeFilter.getCellphone())) {
            cellphone = employeeFilter.getCellphone();
        }
        if (has(cellphone)) {
  
	        sb.append("<b>cellphone</b>: ").append(cellphone).append(", ");
        }
 
        String email = null;
        if (filter.hasParam("email")) {
            email = (String)filter.getParam("email");
        } else if (has(employeeFilter.getEmail())) {
            email = employeeFilter.getEmail();
        }
        if (has(email)) {
  
	        sb.append("<b>email</b>: ").append(email).append(", ");
        }
 
        String postalCode = null;
        if (filter.hasParam("postalCode")) {
            postalCode = (String)filter.getParam("postalCode");
        } else if (has(employeeFilter.getPostalCode())) {
            postalCode = employeeFilter.getPostalCode();
        }
        if (has(postalCode)) {
  
	        sb.append("<b>postalCode</b>: ").append(postalCode).append(", ");
        }
 
        String street = null;
        if (filter.hasParam("street")) {
            street = (String)filter.getParam("street");
        } else if (has(employeeFilter.getStreet())) {
            street = employeeFilter.getStreet();
        }
        if (has(street)) {
  
	        sb.append("<b>street</b>: ").append(street).append(", ");
        }
 
        String houseNumber = null;
        if (filter.hasParam("houseNumber")) {
            houseNumber = (String)filter.getParam("houseNumber");
        } else if (has(employeeFilter.getHouseNumber())) {
            houseNumber = employeeFilter.getHouseNumber();
        }
        if (has(houseNumber)) {
  
	        sb.append("<b>houseNumber</b>: ").append(houseNumber).append(", ");
        }
 
        String complement = null;
        if (filter.hasParam("complement")) {
            complement = (String)filter.getParam("complement");
        } else if (has(employeeFilter.getComplement())) {
            complement = employeeFilter.getComplement();
        }
        if (has(complement)) {
  
	        sb.append("<b>complement</b>: ").append(complement).append(", ");
        }
 
        Country country = null;
        if (filter.hasParam("country")) {
            country = (Country)filter.getParam("country");
        } else if (has(employeeFilter.getCountry())) {
            country = employeeFilter.getCountry();
        }
        if (has(country)) {
            sb.append("<b>country</b>: ").append(country.getCode()).append(", ");
                    }
 
        Province province = null;
        if (filter.hasParam("province")) {
            province = (Province)filter.getParam("province");
        } else if (has(employeeFilter.getProvince())) {
            province = employeeFilter.getProvince();
        }
        if (has(province)) {
            sb.append("<b>province</b>: ").append(province.getCode()).append(", ");
                    }
 
        City city = null;
        if (filter.hasParam("city")) {
            city = (City)filter.getParam("city");
        } else if (has(employeeFilter.getCity())) {
            city = employeeFilter.getCity();
        }
        if (has(city)) {
            sb.append("<b>city</b>: ").append(city.getName()).append(", ");
                    }
 
        Neighborhood neighborhood = null;
        if (filter.hasParam("neighborhood")) {
            neighborhood = (Neighborhood)filter.getParam("neighborhood");
        } else if (has(employeeFilter.getNeighborhood())) {
            neighborhood = employeeFilter.getNeighborhood();
        }
        if (has(neighborhood)) {
            sb.append("<b>neighborhood</b>: ").append(neighborhood.getName()).append(", ");
                    }
 
        String identityNumber = null;
        if (filter.hasParam("identityNumber")) {
            identityNumber = (String)filter.getParam("identityNumber");
        } else if (has(employeeFilter.getIdentityNumber())) {
            identityNumber = employeeFilter.getIdentityNumber();
        }
        if (has(identityNumber)) {
  
	        sb.append("<b>identityNumber</b>: ").append(identityNumber).append(", ");
        }
 
        String identityIssuer = null;
        if (filter.hasParam("identityIssuer")) {
            identityIssuer = (String)filter.getParam("identityIssuer");
        } else if (has(employeeFilter.getIdentityIssuer())) {
            identityIssuer = employeeFilter.getIdentityIssuer();
        }
        if (has(identityIssuer)) {
  
	        sb.append("<b>identityIssuer</b>: ").append(identityIssuer).append(", ");
        }
 
        String taxPayerNumber = null;
        if (filter.hasParam("taxPayerNumber")) {
            taxPayerNumber = (String)filter.getParam("taxPayerNumber");
        } else if (has(employeeFilter.getTaxPayerNumber())) {
            taxPayerNumber = employeeFilter.getTaxPayerNumber();
        }
        if (has(taxPayerNumber)) {
  
	        sb.append("<b>taxPayerNumber</b>: ").append(taxPayerNumber).append(", ");
        }
 
        String socialSecurityId = null;
        if (filter.hasParam("socialSecurityId")) {
            socialSecurityId = (String)filter.getParam("socialSecurityId");
        } else if (has(employeeFilter.getSocialSecurityId())) {
            socialSecurityId = employeeFilter.getSocialSecurityId();
        }
        if (has(socialSecurityId)) {
  
	        sb.append("<b>socialSecurityId</b>: ").append(socialSecurityId).append(", ");
        }
 
        Date admission = null;
        if (filter.hasParam("admission")) {
            admission = (Date)filter.getParam("admission");
        } else if (has(employeeFilter.getAdmission())) {
            admission = employeeFilter.getAdmission();
        }
        if (has(admission)) {
  
	        sb.append("<b>admission</b>: ").append(admission).append(", ");
        }
 
        Date dealStart = null;
        if (filter.hasParam("dealStart")) {
            dealStart = (Date)filter.getParam("dealStart");
        } else if (has(employeeFilter.getDealStart())) {
            dealStart = employeeFilter.getDealStart();
        }
        if (has(dealStart)) {
  
	        sb.append("<b>dealStart</b>: ").append(dealStart).append(", ");
        }
 
        Date dealEnd = null;
        if (filter.hasParam("dealEnd")) {
            dealEnd = (Date)filter.getParam("dealEnd");
        } else if (has(employeeFilter.getDealEnd())) {
            dealEnd = employeeFilter.getDealEnd();
        }
        if (has(dealEnd)) {
  
	        sb.append("<b>dealEnd</b>: ").append(dealEnd).append(", ");
        }
 
        Integer legacySheetId = null;
        if (filter.hasParam("legacySheetId")) {
            legacySheetId = filter.getIntParam("legacySheetId");
        } else if (has(employeeFilter.getLegacySheetId())) {
            legacySheetId = employeeFilter.getLegacySheetId();
        }
        if (has(legacySheetId)) {
  
	        sb.append("<b>legacySheetId</b>: ").append(legacySheetId).append(", ");
        }
 
        Position position = null;
        if (filter.hasParam("position")) {
            position = (Position)filter.getParam("position");
        } else if (has(employeeFilter.getPosition())) {
            position = employeeFilter.getPosition();
        }
        if (has(position)) {
            sb.append("<b>position</b>: ").append(position.getName()).append(", ");
                    }
 
        Schedule schedule = null;
        if (filter.hasParam("schedule")) {
            schedule = (Schedule)filter.getParam("schedule");
        } else if (has(employeeFilter.getSchedule())) {
            schedule = employeeFilter.getSchedule();
        }
        if (has(schedule)) {
            sb.append("<b>schedule</b>: ").append(schedule.getName()).append(", ");
                    }
 
        Company company = null;
        if (filter.hasParam("company")) {
            company = (Company)filter.getParam("company");
        } else if (has(employeeFilter.getCompany())) {
            company = employeeFilter.getCompany();
        }
        if (has(company)) {
            sb.append("<b>company</b>: ").append(company.getName()).append(", ");
                    }
        int commaIndex = sb.lastIndexOf(",");
        if (commaIndex != -1) {
            sb.deleteCharAt(commaIndex);
        }
        if (sb.toString().trim().isEmpty()) {
            PrimeFaces.current().executeScript("jQuery('div[id=footer] .fa-filter').addClass('ui-state-disabled')");
            return getMessage("empty-search-criteria");
        } else {
            PrimeFaces.current().executeScript("jQuery('div[id=footer] .fa-filter').removeClass('ui-state-disabled')");
        }
        return sb.toString();
    }

    public List<Country> completeCountry(String query) {
        return employeeService.getCountrysByCode(query);
    }
    public List<Province> completeProvince(String query) {
        return employeeService.getProvincesByCode(query);
    }
    public List<City> completeCity(String query) {
        return employeeService.getCitysByName(query);
    }
    public List<Neighborhood> completeNeighborhood(String query) {
        return employeeService.getNeighborhoodsByName(query);
    }
    public List<Position> completePosition(String query) {
        return employeeService.getPositionsByName(query);
    }
    public List<Schedule> completeSchedule(String query) {
        return employeeService.getSchedulesByName(query);
    }
    public List<Company> completeCompany(String query) {
        return employeeService.getCompanysByName(query);
    }
}