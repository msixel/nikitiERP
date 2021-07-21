package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.Neighborhood;
import com.blacksmith.nikiti.model.Neighborhood_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.NeighborhoodRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;
import com.blacksmith.nikiti.model.City;      
import com.blacksmith.nikiti.model.City_;   
import javax.persistence.criteria.JoinType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.github.adminfaces.template.util.Assert.has;


 
@Stateless
public class NeighborhoodService extends CrudService<Neighborhood, Long> implements Serializable {

    @Inject
    protected NeighborhoodRepository neighborhoodRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(Neighborhood neighborhood) {
        appLists.clearNeighborhoods();//invalidate Neighborhood list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<Neighborhood, Neighborhood> configRestrictions(Filter<Neighborhood> filter) {
        Criteria<Neighborhood, Neighborhood> criteria = criteria();
        
        if (filter.hasParam(Neighborhood_.id.getName())) {
            criteria.eq(Neighborhood_.id, filter.getLongParam(Neighborhood_.id.getName()));   
        }  
        if (filter.hasParam(Neighborhood_.name.getName())) {
            criteria.eq(Neighborhood_.name, (String)filter.getParam(Neighborhood_.name.getName()));   
        }  
        if (filter.hasParam(Neighborhood_.description.getName())) {
            criteria.eq(Neighborhood_.description, (String)filter.getParam(Neighborhood_.description.getName()));   
        }  
        if (filter.hasParam(Neighborhood_.city.getName())) {
            criteria.join(Neighborhood_.city,
                where(City.class, JoinType.LEFT)
               .eq(City_.id, ((City) filter.getParam("city")).getId()));
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            Neighborhood filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(Neighborhood_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(Neighborhood_.name, filterEntity.getName());   
	        }  
	        if (has(filterEntity.getDescription())) {
                 criteria.eq(Neighborhood_.description, filterEntity.getDescription());   
	        }  
	        if (has(filterEntity.getCity())) {
                 criteria.join(Neighborhood_.city,
                    where(City.class, JoinType.LEFT)
                    .eq(City_.id, filterEntity.getCity().getId()));
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(Neighborhood neighborhood) {
        validate(neighborhood);
    }

    public void beforeUpdate(Neighborhood neighborhood) {
        validate(neighborhood);
    }


    public void validate(Neighborhood neighborhood) {
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
    public List<City> getCitysByName(String query) {
        return criteria(City.class)
               .likeIgnoreCase(City_.name, "%" + query + "%")
               .getResultList();
    }

 
}
