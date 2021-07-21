package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.City;
import com.blacksmith.nikiti.model.City_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.CityRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;
import com.blacksmith.nikiti.model.Province;      
import com.blacksmith.nikiti.model.Province_;   
import javax.persistence.criteria.JoinType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.github.adminfaces.template.util.Assert.has;


 
@Stateless
public class CityService extends CrudService<City, Long> implements Serializable {

    @Inject
    protected CityRepository cityRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(City city) {
        appLists.clearCitys();//invalidate City list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<City, City> configRestrictions(Filter<City> filter) {
        Criteria<City, City> criteria = criteria();
        
        if (filter.hasParam(City_.id.getName())) {
            criteria.eq(City_.id, filter.getLongParam(City_.id.getName()));   
        }  
        if (filter.hasParam(City_.name.getName())) {
            criteria.eq(City_.name, (String)filter.getParam(City_.name.getName()));   
        }  
        if (filter.hasParam(City_.description.getName())) {
            criteria.eq(City_.description, (String)filter.getParam(City_.description.getName()));   
        }  
        if (filter.hasParam(City_.province.getName())) {
            criteria.join(City_.province,
                where(Province.class, JoinType.LEFT)
               .eq(Province_.id, ((Province) filter.getParam("province")).getId()));
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            City filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(City_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(City_.name, filterEntity.getName());   
	        }  
	        if (has(filterEntity.getDescription())) {
                 criteria.eq(City_.description, filterEntity.getDescription());   
	        }  
	        if (has(filterEntity.getProvince())) {
                 criteria.join(City_.province,
                    where(Province.class, JoinType.LEFT)
                    .eq(Province_.id, filterEntity.getProvince().getId()));
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(City city) {
        validate(city);
    }

    public void beforeUpdate(City city) {
        validate(city);
    }


    public void validate(City city) {
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
    public List<Province> getProvincesByCode(String query) {
        return criteria(Province.class)
               .likeIgnoreCase(Province_.code, "%" + query + "%")
               .getResultList();
    }

 
}
