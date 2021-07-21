package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.Country;
import com.blacksmith.nikiti.model.Country_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.CountryRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.github.adminfaces.template.util.Assert.has;


 
@Stateless
public class CountryService extends CrudService<Country, Long> implements Serializable {

    @Inject
    protected CountryRepository countryRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(Country country) {
        appLists.clearCountrys();//invalidate Country list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<Country, Country> configRestrictions(Filter<Country> filter) {
        Criteria<Country, Country> criteria = criteria();
        
        if (filter.hasParam(Country_.id.getName())) {
            criteria.eq(Country_.id, filter.getLongParam(Country_.id.getName()));   
        }  
        if (filter.hasParam(Country_.code.getName())) {
            criteria.eq(Country_.code, (String)filter.getParam(Country_.code.getName()));   
        }  
        if (filter.hasParam(Country_.name.getName())) {
            criteria.eq(Country_.name, (String)filter.getParam(Country_.name.getName()));   
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            Country filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(Country_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getCode())) {
                 criteria.eq(Country_.code, filterEntity.getCode());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(Country_.name, filterEntity.getName());   
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(Country country) {
        validate(country);
    }

    public void beforeUpdate(Country country) {
        validate(country);
    }


    public void validate(Country country) {
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


 
}
