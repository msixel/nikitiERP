package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.github.adminfaces.persistence.util.Messages;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import com.blacksmith.nikiti.model.Company;
import com.blacksmith.nikiti.service.CompanyService;

import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.*;
import org.primefaces.PrimeFaces;
import com.blacksmith.nikiti.model.Country;      
import com.blacksmith.nikiti.model.Province;      
import com.blacksmith.nikiti.model.City;      
import com.blacksmith.nikiti.model.Neighborhood;      
import com.blacksmith.nikiti.model.Employee;   

@Named
@ViewScoped
public class CompanyListMB extends CrudMB<Company> implements Serializable {

    @Inject
    CompanyService companyService;

    List<Employee> companyEmployees;
 
    Map<Long,Boolean> showEmployeesDetailMap = new HashMap<>();//used to show details in datatable rows    

    @Inject
    public void initService() {
        setCrudService(companyService);
    }

    public void delete() {
        int deletedEntities = 0;
        for (Company selected : selectionList) {
        	deletedEntities++;
        	companyService.remove(selected);
        }
        selectionList.clear();
        addDetailMessage(deletedEntities + " company(s) deleted successfully!");
        clear();
    }

    /**
     * Used in datatable footer to display current search criteria
     */
    public String getSearchCriteria() {
        StringBuilder sb = new StringBuilder(21);
        Company companyFilter = filter.getEntity();
 
        Long id = null;
        if (filter.hasParam("id")) {
            id = filter.getLongParam("id");
        } else if (has(companyFilter.getId())) {
            id = companyFilter.getId();
        }
        if (has(id)) {
  
	        sb.append("<b>id</b>: ").append(id).append(", ");
        }
 
        String name = null;
        if (filter.hasParam("name")) {
            name = (String)filter.getParam("name");
        } else if (has(companyFilter.getName())) {
            name = companyFilter.getName();
        }
        if (has(name)) {
  
	        sb.append("<b>name</b>: ").append(name).append(", ");
        }
 
        String description = null;
        if (filter.hasParam("description")) {
            description = (String)filter.getParam("description");
        } else if (has(companyFilter.getDescription())) {
            description = companyFilter.getDescription();
        }
        if (has(description)) {
  
	        sb.append("<b>description</b>: ").append(description).append(", ");
        }
 
        String landline = null;
        if (filter.hasParam("landline")) {
            landline = (String)filter.getParam("landline");
        } else if (has(companyFilter.getLandline())) {
            landline = companyFilter.getLandline();
        }
        if (has(landline)) {
  
	        sb.append("<b>landline</b>: ").append(landline).append(", ");
        }
 
        String cellphone = null;
        if (filter.hasParam("cellphone")) {
            cellphone = (String)filter.getParam("cellphone");
        } else if (has(companyFilter.getCellphone())) {
            cellphone = companyFilter.getCellphone();
        }
        if (has(cellphone)) {
  
	        sb.append("<b>cellphone</b>: ").append(cellphone).append(", ");
        }
 
        String email = null;
        if (filter.hasParam("email")) {
            email = (String)filter.getParam("email");
        } else if (has(companyFilter.getEmail())) {
            email = companyFilter.getEmail();
        }
        if (has(email)) {
  
	        sb.append("<b>email</b>: ").append(email).append(", ");
        }
 
        String postalCode = null;
        if (filter.hasParam("postalCode")) {
            postalCode = (String)filter.getParam("postalCode");
        } else if (has(companyFilter.getPostalCode())) {
            postalCode = companyFilter.getPostalCode();
        }
        if (has(postalCode)) {
  
	        sb.append("<b>postalCode</b>: ").append(postalCode).append(", ");
        }
 
        String street = null;
        if (filter.hasParam("street")) {
            street = (String)filter.getParam("street");
        } else if (has(companyFilter.getStreet())) {
            street = companyFilter.getStreet();
        }
        if (has(street)) {
  
	        sb.append("<b>street</b>: ").append(street).append(", ");
        }
 
        String houseNumber = null;
        if (filter.hasParam("houseNumber")) {
            houseNumber = (String)filter.getParam("houseNumber");
        } else if (has(companyFilter.getHouseNumber())) {
            houseNumber = companyFilter.getHouseNumber();
        }
        if (has(houseNumber)) {
  
	        sb.append("<b>houseNumber</b>: ").append(houseNumber).append(", ");
        }
 
        String complement = null;
        if (filter.hasParam("complement")) {
            complement = (String)filter.getParam("complement");
        } else if (has(companyFilter.getComplement())) {
            complement = companyFilter.getComplement();
        }
        if (has(complement)) {
  
	        sb.append("<b>complement</b>: ").append(complement).append(", ");
        }
 
        Country country = null;
        if (filter.hasParam("country")) {
            country = (Country)filter.getParam("country");
        } else if (has(companyFilter.getCountry())) {
            country = companyFilter.getCountry();
        }
        if (has(country)) {
            sb.append("<b>country</b>: ").append(country.getCode()).append(", ");
                    }
 
        Province province = null;
        if (filter.hasParam("province")) {
            province = (Province)filter.getParam("province");
        } else if (has(companyFilter.getProvince())) {
            province = companyFilter.getProvince();
        }
        if (has(province)) {
            sb.append("<b>province</b>: ").append(province.getCode()).append(", ");
                    }
 
        City city = null;
        if (filter.hasParam("city")) {
            city = (City)filter.getParam("city");
        } else if (has(companyFilter.getCity())) {
            city = companyFilter.getCity();
        }
        if (has(city)) {
            sb.append("<b>city</b>: ").append(city.getName()).append(", ");
                    }
 
        Neighborhood neighborhood = null;
        if (filter.hasParam("neighborhood")) {
            neighborhood = (Neighborhood)filter.getParam("neighborhood");
        } else if (has(companyFilter.getNeighborhood())) {
            neighborhood = companyFilter.getNeighborhood();
        }
        if (has(neighborhood)) {
            sb.append("<b>neighborhood</b>: ").append(neighborhood.getName()).append(", ");
                    }
        Set<Employee> employees = null;
        if (filter.hasParam("employees")) {
           employees = (Set<Employee>) filter.getParam("employees");
        } else if (has(companyFilter.getEmployees())) {
            employees = companyFilter.getEmployees();
        }
        if (has(employees)) {
            sb.append("<b>employees</b>: ");
            for (Employee employee : employees) {
                sb.append(employee.getName()).append(", ");
            }
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
        return companyService.getCountrysByCode(query);
    }
    public List<Province> completeProvince(String query) {
        return companyService.getProvincesByCode(query);
    }
    public List<City> completeCity(String query) {
        return companyService.getCitysByName(query);
    }
    public List<Neighborhood> completeNeighborhood(String query) {
        return companyService.getNeighborhoodsByName(query);
    }
    public void showEmployeesDetail(Long id) {
        this.showEmployeesDetailMap.clear();//show details of one row at a time
        this.showEmployeesDetailMap.put(id,true);
        companyEmployees = companyService.getEmployeesByCompanyId(id);  
    }
    
    public List<Employee> getCompanyEmployees() {
        return companyEmployees;
    }

    public void setcompanyEmployees(List<Employee> companyEmployees) {
        this.companyEmployees = companyEmployees;
    }

    public Map<Long,Boolean> getShowEmployeesDetailMap() {
        return showEmployeesDetailMap;
    }

}