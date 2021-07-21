package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.Facility;
import com.blacksmith.nikiti.model.Facility_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.FacilityRepository;
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
import com.blacksmith.nikiti.model.Company;   
import com.blacksmith.nikiti.model.Company_;   
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
public class FacilityService extends CrudService<Facility, Long> implements Serializable {

    @Inject
    protected FacilityRepository facilityRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(Facility facility) {
        appLists.clearFacilitys();//invalidate Facility list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<Facility, Facility> configRestrictions(Filter<Facility> filter) {
        Criteria<Facility, Facility> criteria = criteria();
        
        if (filter.hasParam(Facility_.id.getName())) {
            criteria.eq(Facility_.id, filter.getLongParam(Facility_.id.getName()));   
        }  
        if (filter.hasParam(Facility_.name.getName())) {
            criteria.eq(Facility_.name, (String)filter.getParam(Facility_.name.getName()));   
        }  
        if (filter.hasParam(Facility_.description.getName())) {
            criteria.eq(Facility_.description, (String)filter.getParam(Facility_.description.getName()));   
        }  
        if (filter.hasParam(Facility_.landline.getName())) {
            criteria.eq(Facility_.landline, (String)filter.getParam(Facility_.landline.getName()));   
        }  
        if (filter.hasParam(Facility_.cellphone.getName())) {
            criteria.eq(Facility_.cellphone, (String)filter.getParam(Facility_.cellphone.getName()));   
        }  
        if (filter.hasParam(Facility_.email.getName())) {
            criteria.eq(Facility_.email, (String)filter.getParam(Facility_.email.getName()));   
        }  
        if (filter.hasParam(Facility_.postalCode.getName())) {
            criteria.eq(Facility_.postalCode, (String)filter.getParam(Facility_.postalCode.getName()));   
        }  
        if (filter.hasParam(Facility_.street.getName())) {
            criteria.eq(Facility_.street, (String)filter.getParam(Facility_.street.getName()));   
        }  
        if (filter.hasParam(Facility_.houseNumber.getName())) {
            criteria.eq(Facility_.houseNumber, (String)filter.getParam(Facility_.houseNumber.getName()));   
        }  
        if (filter.hasParam(Facility_.complement.getName())) {
            criteria.eq(Facility_.complement, (String)filter.getParam(Facility_.complement.getName()));   
        }  
        if (filter.hasParam(Facility_.country.getName())) {
            criteria.join(Facility_.country,
                where(Country.class, JoinType.LEFT)
               .eq(Country_.id, ((Country) filter.getParam("country")).getId()));
        }  
        if (filter.hasParam(Facility_.province.getName())) {
            criteria.join(Facility_.province,
                where(Province.class, JoinType.LEFT)
               .eq(Province_.id, ((Province) filter.getParam("province")).getId()));
        }  
        if (filter.hasParam(Facility_.city.getName())) {
            criteria.join(Facility_.city,
                where(City.class, JoinType.LEFT)
               .eq(City_.id, ((City) filter.getParam("city")).getId()));
        }  
        if (filter.hasParam(Facility_.neighborhood.getName())) {
            criteria.join(Facility_.neighborhood,
                where(Neighborhood.class, JoinType.LEFT)
               .eq(Neighborhood_.id, ((Neighborhood) filter.getParam("neighborhood")).getId()));
        }  
        if (filter.hasParam(Facility_.companies.getName())) {
            criteria.distinct().join(Facility_.companies, where(Company.class, JoinType.LEFT)
                .in(Company_.id, toListOfIds((Set<Company>) filter.getParam(Facility_.companies.getName()), new Long[0])));   
        }  
        if (filter.hasParam(Facility_.employees.getName())) {
            criteria.distinct().join(Facility_.employees, where(Employee.class, JoinType.LEFT)
                .in(Employee_.id, toListOfIds((Set<Employee>) filter.getParam(Facility_.employees.getName()), new Long[0])));   
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            Facility filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(Facility_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(Facility_.name, filterEntity.getName());   
	        }  
	        if (has(filterEntity.getDescription())) {
                 criteria.eq(Facility_.description, filterEntity.getDescription());   
	        }  
	        if (has(filterEntity.getLandline())) {
                 criteria.eq(Facility_.landline, filterEntity.getLandline());   
	        }  
	        if (has(filterEntity.getCellphone())) {
                 criteria.eq(Facility_.cellphone, filterEntity.getCellphone());   
	        }  
	        if (has(filterEntity.getEmail())) {
                 criteria.eq(Facility_.email, filterEntity.getEmail());   
	        }  
	        if (has(filterEntity.getPostalCode())) {
                 criteria.eq(Facility_.postalCode, filterEntity.getPostalCode());   
	        }  
	        if (has(filterEntity.getStreet())) {
                 criteria.eq(Facility_.street, filterEntity.getStreet());   
	        }  
	        if (has(filterEntity.getHouseNumber())) {
                 criteria.eq(Facility_.houseNumber, filterEntity.getHouseNumber());   
	        }  
	        if (has(filterEntity.getComplement())) {
                 criteria.eq(Facility_.complement, filterEntity.getComplement());   
	        }  
	        if (has(filterEntity.getCountry())) {
                 criteria.join(Facility_.country,
                    where(Country.class, JoinType.LEFT)
                    .eq(Country_.id, filterEntity.getCountry().getId()));
	        }  
	        if (has(filterEntity.getProvince())) {
                 criteria.join(Facility_.province,
                    where(Province.class, JoinType.LEFT)
                    .eq(Province_.id, filterEntity.getProvince().getId()));
	        }  
	        if (has(filterEntity.getCity())) {
                 criteria.join(Facility_.city,
                    where(City.class, JoinType.LEFT)
                    .eq(City_.id, filterEntity.getCity().getId()));
	        }  
	        if (has(filterEntity.getNeighborhood())) {
                 criteria.join(Facility_.neighborhood,
                    where(Neighborhood.class, JoinType.LEFT)
                    .eq(Neighborhood_.id, filterEntity.getNeighborhood().getId()));
	        }  
	        if (has(filterEntity.getCompanies())) {
                 criteria.distinct().join(Facility_.companies, where(Company.class, JoinType.LEFT)
 	  	    .in(Company_.id, toListOfIds(filterEntity.getCompanies(), new Long[0])));   
	        }  
	        if (has(filterEntity.getEmployees())) {
                 criteria.distinct().join(Facility_.employees, where(Employee.class, JoinType.LEFT)
 	  	    .in(Employee_.id, toListOfIds(filterEntity.getEmployees(), new Long[0])));   
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(Facility facility) {
        validate(facility);
    }

    public void beforeUpdate(Facility facility) {
        validate(facility);
    }

    @Override
    public void beforeRemove(Facility facility) {

    }

    public void validate(Facility facility) {
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
    public List<Company> getCompaniesByFacilityId(Long facilityId) {
         return getEntityManager().createQuery("select r from Company r where r.facility.id =:id",Company.class)
                .setParameter("id",facilityId)
                .getResultList(); 
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Employee> getEmployeesByFacilityId(Long facilityId) {
         return getEntityManager().createQuery("select r from Employee r where r.facility.id =:id",Employee.class)
                .setParameter("id",facilityId)
                .getResultList(); 
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Facility findById(Serializable id) {
        TypedQuery<Facility> findById = getEntityManager().createQuery("select s from Facility s left join fetch s.companiesleft join fetch s.employees where s.id = :id", Facility.class)
            .setParameter("id", id);
        try {
            return findById.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
 
}
