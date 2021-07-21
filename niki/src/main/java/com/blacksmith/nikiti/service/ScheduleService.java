package com.blacksmith.nikiti.service;

import com.github.adminfaces.persistence.model.Filter;
import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.template.exception.BusinessException;
import org.apache.deltaspike.data.api.criteria.Criteria;
import com.blacksmith.nikiti.model.Schedule;
import com.blacksmith.nikiti.model.Schedule_;
import com.blacksmith.nikiti.bean.AppLists;
import com.blacksmith.nikiti.repository.ScheduleRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.*;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import static com.github.adminfaces.template.util.Assert.has;


 
@Stateless
public class ScheduleService extends CrudService<Schedule, Long> implements Serializable {

    @Inject
    protected ScheduleRepository scheduleRepository;// you can use repositories to extract complex queries from your service

    @Inject
    protected AppLists appLists;

    @Override
    public void afterAll(Schedule schedule) {
        appLists.clearSchedules();//invalidate Schedule list cache
    }

    /** 
     * This method is used for (real) pagination and is called by lazy 
     * PrimeFaces datatable on list page
     *
     * @param filter holds restrictions populated on the list page
     * @return a criteria populated with given restrictions 
     */ 
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    protected Criteria<Schedule, Schedule> configRestrictions(Filter<Schedule> filter) {
        Criteria<Schedule, Schedule> criteria = criteria();
        
        if (filter.hasParam(Schedule_.id.getName())) {
            criteria.eq(Schedule_.id, filter.getLongParam(Schedule_.id.getName()));   
        }  
        if (filter.hasParam(Schedule_.name.getName())) {
            criteria.eq(Schedule_.name, (String)filter.getParam(Schedule_.name.getName()));   
        }  
        if (filter.hasParam(Schedule_.description.getName())) {
            criteria.eq(Schedule_.description, (String)filter.getParam(Schedule_.description.getName()));   
        }  

        //create restrictions based on filter entity
        if (has(filter.getEntity())) {
            Schedule filterEntity = filter.getEntity();
            
	        if (has(filterEntity.getId())) {
                 criteria.eq(Schedule_.id, filterEntity.getId());   
	        }  
	        if (has(filterEntity.getName())) {
                 criteria.eq(Schedule_.name, filterEntity.getName());   
	        }  
	        if (has(filterEntity.getDescription())) {
                 criteria.eq(Schedule_.description, filterEntity.getDescription());   
	        }  
        }
        return criteria;
    }
    
    public void beforeInsert(Schedule schedule) {
        validate(schedule);
    }

    public void beforeUpdate(Schedule schedule) {
        validate(schedule);
    }


    public void validate(Schedule schedule) {
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
