package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.Province;
import com.blacksmith.nikiti.model.Province_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.ProvinceRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;
import com.blacksmith.nikiti.model.Country;      
import com.blacksmith.nikiti.model.Country_;   
import javax.persistence.criteria.JoinType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.github.adminfaces.template.util.Assert.has;


 
@Stateless
public class ProvinceService extends CrudService<Province, Long> implements Serializable {

    @Inject
    protected ProvinceRepository provinceRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(Province province) {
        appLists.clearProvinces();//invalidate Province list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<Province, Province> configRestrictions(Filter<Province> filter) {
        Criteria<Province, Province> criteria = criteria();
        
        if (filter.hasParam(Province_.id.getName())) {
            criteria.eq(Province_.id, filter.getLongParam(Province_.id.getName()));   
        }  
        if (filter.hasParam(Province_.code.getName())) {
            criteria.eq(Province_.code, (String)filter.getParam(Province_.code.getName()));   
        }  
        if (filter.hasParam(Province_.name.getName())) {
            criteria.eq(Province_.name, (String)filter.getParam(Province_.name.getName()));   
        }  
        if (filter.hasParam(Province_.country.getName())) {
            criteria.join(Province_.country,
                where(Country.class, JoinType.LEFT)
               .eq(Country_.id, ((Country) filter.getParam("country")).getId()));
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            Province filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(Province_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getCode())) {
                 criteria.eq(Province_.code, filterEntity.getCode());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(Province_.name, filterEntity.getName());   
	        }  
	        if (has(filterEntity.getCountry())) {
                 criteria.join(Province_.country,
                    where(Country.class, JoinType.LEFT)
                    .eq(Country_.id, filterEntity.getCountry().getId()));
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(Province province) {
        validate(province);
    }

    public void beforeUpdate(Province province) {
        validate(province);
    }


    public void validate(Province province) {
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

 
}
