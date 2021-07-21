package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.Employee;
import com.blacksmith.nikiti.model.Employee_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.EmployeeRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;
import com.blacksmith.nikiti.model.Country;      
import com.blacksmith.nikiti.model.Country_;   
import com.blacksmith.nikiti.model.Province;      
import com.blacksmith.nikiti.model.Province_;   
import com.blacksmith.nikiti.model.City;      
import com.blacksmith.nikiti.model.City_;   
import com.blacksmith.nikiti.model.Neighborhood;      
import com.blacksmith.nikiti.model.Neighborhood_;   
import com.blacksmith.nikiti.model.Position;      
import com.blacksmith.nikiti.model.Position_;   
import com.blacksmith.nikiti.model.Schedule;      
import com.blacksmith.nikiti.model.Schedule_;   
import com.blacksmith.nikiti.model.Company;      
import com.blacksmith.nikiti.model.Company_;   
import javax.persistence.criteria.JoinType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.github.adminfaces.template.util.Assert.has;


 
@Stateless
public class EmployeeService extends CrudService<Employee, Long> implements Serializable {

    @Inject
    protected EmployeeRepository employeeRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(Employee employee) {
        appLists.clearEmployees();//invalidate Employee list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<Employee, Employee> configRestrictions(Filter<Employee> filter) {
        Criteria<Employee, Employee> criteria = criteria();
        
        if (filter.hasParam(Employee_.id.getName())) {
            criteria.eq(Employee_.id, filter.getLongParam(Employee_.id.getName()));   
        }  
        if (filter.hasParam(Employee_.name.getName())) {
            criteria.eq(Employee_.name, (String)filter.getParam(Employee_.name.getName()));   
        }  
        if (filter.hasParam(Employee_.description.getName())) {
            criteria.eq(Employee_.description, (String)filter.getParam(Employee_.description.getName()));   
        }  
        if (filter.hasParam(Employee_.birth.getName())) {
            criteria.eq(Employee_.birth, (Date)filter.getParam(Employee_.birth.getName()));   
        }  
        if (filter.hasParam(Employee_.landline.getName())) {
            criteria.eq(Employee_.landline, (String)filter.getParam(Employee_.landline.getName()));   
        }  
        if (filter.hasParam(Employee_.cellphone.getName())) {
            criteria.eq(Employee_.cellphone, (String)filter.getParam(Employee_.cellphone.getName()));   
        }  
        if (filter.hasParam(Employee_.email.getName())) {
            criteria.eq(Employee_.email, (String)filter.getParam(Employee_.email.getName()));   
        }  
        if (filter.hasParam(Employee_.postalCode.getName())) {
            criteria.eq(Employee_.postalCode, (String)filter.getParam(Employee_.postalCode.getName()));   
        }  
        if (filter.hasParam(Employee_.street.getName())) {
            criteria.eq(Employee_.street, (String)filter.getParam(Employee_.street.getName()));   
        }  
        if (filter.hasParam(Employee_.houseNumber.getName())) {
            criteria.eq(Employee_.houseNumber, (String)filter.getParam(Employee_.houseNumber.getName()));   
        }  
        if (filter.hasParam(Employee_.complement.getName())) {
            criteria.eq(Employee_.complement, (String)filter.getParam(Employee_.complement.getName()));   
        }  
        if (filter.hasParam(Employee_.country.getName())) {
            criteria.join(Employee_.country,
                where(Country.class, JoinType.LEFT)
               .eq(Country_.id, ((Country) filter.getParam("country")).getId()));
        }  
        if (filter.hasParam(Employee_.province.getName())) {
            criteria.join(Employee_.province,
                where(Province.class, JoinType.LEFT)
               .eq(Province_.id, ((Province) filter.getParam("province")).getId()));
        }  
        if (filter.hasParam(Employee_.city.getName())) {
            criteria.join(Employee_.city,
                where(City.class, JoinType.LEFT)
               .eq(City_.id, ((City) filter.getParam("city")).getId()));
        }  
        if (filter.hasParam(Employee_.neighborhood.getName())) {
            criteria.join(Employee_.neighborhood,
                where(Neighborhood.class, JoinType.LEFT)
               .eq(Neighborhood_.id, ((Neighborhood) filter.getParam("neighborhood")).getId()));
        }  
        if (filter.hasParam(Employee_.identityNumber.getName())) {
            criteria.eq(Employee_.identityNumber, (String)filter.getParam(Employee_.identityNumber.getName()));   
        }  
        if (filter.hasParam(Employee_.identityIssuer.getName())) {
            criteria.eq(Employee_.identityIssuer, (String)filter.getParam(Employee_.identityIssuer.getName()));   
        }  
        if (filter.hasParam(Employee_.taxPayerNumber.getName())) {
            criteria.eq(Employee_.taxPayerNumber, (String)filter.getParam(Employee_.taxPayerNumber.getName()));   
        }  
        if (filter.hasParam(Employee_.socialSecurityId.getName())) {
            criteria.eq(Employee_.socialSecurityId, (String)filter.getParam(Employee_.socialSecurityId.getName()));   
        }  
        if (filter.hasParam(Employee_.admission.getName())) {
            criteria.eq(Employee_.admission, (Date)filter.getParam(Employee_.admission.getName()));   
        }  
        if (filter.hasParam(Employee_.dealStart.getName())) {
            criteria.eq(Employee_.dealStart, (Date)filter.getParam(Employee_.dealStart.getName()));   
        }  
        if (filter.hasParam(Employee_.dealEnd.getName())) {
            criteria.eq(Employee_.dealEnd, (Date)filter.getParam(Employee_.dealEnd.getName()));   
        }  
        if (filter.hasParam(Employee_.legacySheetId.getName())) {
            criteria.eq(Employee_.legacySheetId, filter.getIntParam(Employee_.legacySheetId.getName()));   
        }  
        if (filter.hasParam(Employee_.position.getName())) {
            criteria.join(Employee_.position,
                where(Position.class, JoinType.LEFT)
               .eq(Position_.id, ((Position) filter.getParam("position")).getId()));
        }  
        if (filter.hasParam(Employee_.schedule.getName())) {
            criteria.join(Employee_.schedule,
                where(Schedule.class, JoinType.LEFT)
               .eq(Schedule_.id, ((Schedule) filter.getParam("schedule")).getId()));
        }  
        if (filter.hasParam(Employee_.company.getName())) {
            criteria.join(Employee_.company,
                where(Company.class, JoinType.LEFT)
               .eq(Company_.id, ((Company) filter.getParam("company")).getId()));
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            Employee filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(Employee_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(Employee_.name, filterEntity.getName());   
	        }  
	        if (has(filterEntity.getDescription())) {
                 criteria.eq(Employee_.description, filterEntity.getDescription());   
	        }  
	        if (has(filterEntity.getBirth())) {
                 criteria.eq(Employee_.birth, filterEntity.getBirth());   
	        }  
	        if (has(filterEntity.getLandline())) {
                 criteria.eq(Employee_.landline, filterEntity.getLandline());   
	        }  
	        if (has(filterEntity.getCellphone())) {
                 criteria.eq(Employee_.cellphone, filterEntity.getCellphone());   
	        }  
	        if (has(filterEntity.getEmail())) {
                 criteria.eq(Employee_.email, filterEntity.getEmail());   
	        }  
	        if (has(filterEntity.getPostalCode())) {
                 criteria.eq(Employee_.postalCode, filterEntity.getPostalCode());   
	        }  
	        if (has(filterEntity.getStreet())) {
                 criteria.eq(Employee_.street, filterEntity.getStreet());   
	        }  
	        if (has(filterEntity.getHouseNumber())) {
                 criteria.eq(Employee_.houseNumber, filterEntity.getHouseNumber());   
	        }  
	        if (has(filterEntity.getComplement())) {
                 criteria.eq(Employee_.complement, filterEntity.getComplement());   
	        }  
	        if (has(filterEntity.getCountry())) {
                 criteria.join(Employee_.country,
                    where(Country.class, JoinType.LEFT)
                    .eq(Country_.id, filterEntity.getCountry().getId()));
	        }  
	        if (has(filterEntity.getProvince())) {
                 criteria.join(Employee_.province,
                    where(Province.class, JoinType.LEFT)
                    .eq(Province_.id, filterEntity.getProvince().getId()));
	        }  
	        if (has(filterEntity.getCity())) {
                 criteria.join(Employee_.city,
                    where(City.class, JoinType.LEFT)
                    .eq(City_.id, filterEntity.getCity().getId()));
	        }  
	        if (has(filterEntity.getNeighborhood())) {
                 criteria.join(Employee_.neighborhood,
                    where(Neighborhood.class, JoinType.LEFT)
                    .eq(Neighborhood_.id, filterEntity.getNeighborhood().getId()));
	        }  
	        if (has(filterEntity.getIdentityNumber())) {
                 criteria.eq(Employee_.identityNumber, filterEntity.getIdentityNumber());   
	        }  
	        if (has(filterEntity.getIdentityIssuer())) {
                 criteria.eq(Employee_.identityIssuer, filterEntity.getIdentityIssuer());   
	        }  
	        if (has(filterEntity.getTaxPayerNumber())) {
                 criteria.eq(Employee_.taxPayerNumber, filterEntity.getTaxPayerNumber());   
	        }  
	        if (has(filterEntity.getSocialSecurityId())) {
                 criteria.eq(Employee_.socialSecurityId, filterEntity.getSocialSecurityId());   
	        }  
	        if (has(filterEntity.getAdmission())) {
                 criteria.eq(Employee_.admission, filterEntity.getAdmission());   
	        }  
	        if (has(filterEntity.getDealStart())) {
                 criteria.eq(Employee_.dealStart, filterEntity.getDealStart());   
	        }  
	        if (has(filterEntity.getDealEnd())) {
                 criteria.eq(Employee_.dealEnd, filterEntity.getDealEnd());   
	        }  
	        if (has(filterEntity.getLegacySheetId())) {
                 criteria.eq(Employee_.legacySheetId, filterEntity.getLegacySheetId());   
	        }  
	        if (has(filterEntity.getPosition())) {
                 criteria.join(Employee_.position,
                    where(Position.class, JoinType.LEFT)
                    .eq(Position_.id, filterEntity.getPosition().getId()));
	        }  
	        if (has(filterEntity.getSchedule())) {
                 criteria.join(Employee_.schedule,
                    where(Schedule.class, JoinType.LEFT)
                    .eq(Schedule_.id, filterEntity.getSchedule().getId()));
	        }  
	        if (has(filterEntity.getCompany())) {
                 criteria.join(Employee_.company,
                    where(Company.class, JoinType.LEFT)
                    .eq(Company_.id, filterEntity.getCompany().getId()));
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(Employee employee) {
        validate(employee);
    }

    public void beforeUpdate(Employee employee) {
        validate(employee);
    }


    public void validate(Employee employee) {
        BusinessException be = new BusinessException();

        /** just an example of validation
        if (!car.hasModel()) {
            be.addException(new BusinessException("Car model cannot be empty"));
        }
        if (!car.hasName()) {
            be.addException(new BusinessException("Car name cannot be empty"));
        }

        if (!has(car.getPrice())) {
            be.addException(new BusinessException("Car price cannot be empty"));
        } 

        if (count(criteria()
                .eqIgnoreCase(Car_.name, car.getName())
                .notEq(Car_.id, car.getId())) > 0) {

            be.addException(new BusinessException("Car name must be unique"));
        }
        **/

        //if there is exceptions enqueued then throw them. Each business exception will be transformed into a JSF error message and displayed on the page
        if (has(be.getExceptionList())) {
            throw be;
        }
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Country> getCountrysByCode(String query) {
        return criteria(Country.class)
               .likeIgnoreCase(Country_.code, "%" + query + "%")
               .getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Province> getProvincesByCode(String query) {
        return criteria(Province.class)
               .likeIgnoreCase(Province_.code, "%" + query + "%")
               .getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<City> getCitysByName(String query) {
        return criteria(City.class)
               .likeIgnoreCase(City_.name, "%" + query + "%")
               .getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Neighborhood> getNeighborhoodsByName(String query) {
        return criteria(Neighborhood.class)
               .likeIgnoreCase(Neighborhood_.name, "%" + query + "%")
               .getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Position> getPositionsByName(String query) {
        return criteria(Position.class)
               .likeIgnoreCase(Position_.name, "%" + query + "%")
               .getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Schedule> getSchedulesByName(String query) {
        return criteria(Schedule.class)
               .likeIgnoreCase(Schedule_.name, "%" + query + "%")
               .getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Company> getCompanysByName(String query) {
        return criteria(Company.class)
               .likeIgnoreCase(Company_.name, "%" + query + "%")
               .getResultList();
    }

 
}
