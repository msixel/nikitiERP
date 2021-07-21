package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.Company;
import com.blacksmith.nikiti.model.Company_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.CompanyRepository;
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
import com.blacksmith.nikiti.model.Employee;   
import com.blacksmith.nikiti.model.Employee_;   
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.JoinType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.github.adminfaces.template.util.Assert.has;


 
@Stateless
public class CompanyService extends CrudService<Company, Long> implements Serializable {

    @Inject
    protected CompanyRepository companyRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(Company company) {
        appLists.clearCompanys();//invalidate Company list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<Company, Company> configRestrictions(Filter<Company> filter) {
        Criteria<Company, Company> criteria = criteria();
        
        if (filter.hasParam(Company_.id.getName())) {
            criteria.eq(Company_.id, filter.getLongParam(Company_.id.getName()));   
        }  
        if (filter.hasParam(Company_.name.getName())) {
            criteria.eq(Company_.name, (String)filter.getParam(Company_.name.getName()));   
        }  
        if (filter.hasParam(Company_.description.getName())) {
            criteria.eq(Company_.description, (String)filter.getParam(Company_.description.getName()));   
        }  
        if (filter.hasParam(Company_.landline.getName())) {
            criteria.eq(Company_.landline, (String)filter.getParam(Company_.landline.getName()));   
        }  
        if (filter.hasParam(Company_.cellphone.getName())) {
            criteria.eq(Company_.cellphone, (String)filter.getParam(Company_.cellphone.getName()));   
        }  
        if (filter.hasParam(Company_.email.getName())) {
            criteria.eq(Company_.email, (String)filter.getParam(Company_.email.getName()));   
        }  
        if (filter.hasParam(Company_.postalCode.getName())) {
            criteria.eq(Company_.postalCode, (String)filter.getParam(Company_.postalCode.getName()));   
        }  
        if (filter.hasParam(Company_.street.getName())) {
            criteria.eq(Company_.street, (String)filter.getParam(Company_.street.getName()));   
        }  
        if (filter.hasParam(Company_.houseNumber.getName())) {
            criteria.eq(Company_.houseNumber, (String)filter.getParam(Company_.houseNumber.getName()));   
        }  
        if (filter.hasParam(Company_.complement.getName())) {
            criteria.eq(Company_.complement, (String)filter.getParam(Company_.complement.getName()));   
        }  
        if (filter.hasParam(Company_.country.getName())) {
            criteria.join(Company_.country,
                where(Country.class, JoinType.LEFT)
               .eq(Country_.id, ((Country) filter.getParam("country")).getId()));
        }  
        if (filter.hasParam(Company_.province.getName())) {
            criteria.join(Company_.province,
                where(Province.class, JoinType.LEFT)
               .eq(Province_.id, ((Province) filter.getParam("province")).getId()));
        }  
        if (filter.hasParam(Company_.city.getName())) {
            criteria.join(Company_.city,
                where(City.class, JoinType.LEFT)
               .eq(City_.id, ((City) filter.getParam("city")).getId()));
        }  
        if (filter.hasParam(Company_.neighborhood.getName())) {
            criteria.join(Company_.neighborhood,
                where(Neighborhood.class, JoinType.LEFT)
               .eq(Neighborhood_.id, ((Neighborhood) filter.getParam("neighborhood")).getId()));
        }  
        if (filter.hasParam(Company_.employees.getName())) {
            criteria.distinct().join(Company_.employees, where(Employee.class, JoinType.LEFT)
                .in(Employee_.id, toListOfIds((Set<Employee>) filter.getParam(Company_.employees.getName()), new Long[0])));   
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            Company filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(Company_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(Company_.name, filterEntity.getName());   
	        }  
	        if (has(filterEntity.getDescription())) {
                 criteria.eq(Company_.description, filterEntity.getDescription());   
	        }  
	        if (has(filterEntity.getLandline())) {
                 criteria.eq(Company_.landline, filterEntity.getLandline());   
	        }  
	        if (has(filterEntity.getCellphone())) {
                 criteria.eq(Company_.cellphone, filterEntity.getCellphone());   
	        }  
	        if (has(filterEntity.getEmail())) {
                 criteria.eq(Company_.email, filterEntity.getEmail());   
	        }  
	        if (has(filterEntity.getPostalCode())) {
                 criteria.eq(Company_.postalCode, filterEntity.getPostalCode());   
	        }  
	        if (has(filterEntity.getStreet())) {
                 criteria.eq(Company_.street, filterEntity.getStreet());   
	        }  
	        if (has(filterEntity.getHouseNumber())) {
                 criteria.eq(Company_.houseNumber, filterEntity.getHouseNumber());   
	        }  
	        if (has(filterEntity.getComplement())) {
                 criteria.eq(Company_.complement, filterEntity.getComplement());   
	        }  
	        if (has(filterEntity.getCountry())) {
                 criteria.join(Company_.country,
                    where(Country.class, JoinType.LEFT)
                    .eq(Country_.id, filterEntity.getCountry().getId()));
	        }  
	        if (has(filterEntity.getProvince())) {
                 criteria.join(Company_.province,
                    where(Province.class, JoinType.LEFT)
                    .eq(Province_.id, filterEntity.getProvince().getId()));
	        }  
	        if (has(filterEntity.getCity())) {
                 criteria.join(Company_.city,
                    where(City.class, JoinType.LEFT)
                    .eq(City_.id, filterEntity.getCity().getId()));
	        }  
	        if (has(filterEntity.getNeighborhood())) {
                 criteria.join(Company_.neighborhood,
                    where(Neighborhood.class, JoinType.LEFT)
                    .eq(Neighborhood_.id, filterEntity.getNeighborhood().getId()));
	        }  
	        if (has(filterEntity.getEmployees())) {
                 criteria.distinct().join(Company_.employees, where(Employee.class, JoinType.LEFT)
 	  	    .in(Employee_.id, toListOfIds(filterEntity.getEmployees(), new Long[0])));   
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(Company company) {
        validate(company);
    }

    public void beforeUpdate(Company company) {
        validate(company);
    }

    @Override
    public void beforeRemove(Company company) {
        Criteria<Company, Company> companyEmployeesCriteria = criteria().
            join(Company_.employees, where(Employee.class, JoinType.LEFT)
                .eq(Employee_.company, company));
        
        if(count(companyEmployeesCriteria) > 0) {
            throw new BusinessException("Cannot remove "+company.getName() + " because it has employees associated.");
        }

    }

    public void validate(Company company) {
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
    public List<Employee> getEmployeesByCompanyId(Long companyId) {
         return getEntityManager().createQuery("select r from Employee r where r.company.id =:id",Employee.class)
                .setParameter("id",companyId)
                .getResultList(); 
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Company findById(Serializable id) {
        TypedQuery<Company> findById = getEntityManager().createQuery("select s from Company s left join fetch s.employees where s.id = :id", Company.class)
            .setParameter("id", id);
        try {
            return findById.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
 
}
