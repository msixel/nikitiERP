package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.github.adminfaces.persistence.util.Messages;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import com.blacksmith.nikiti.model.Neighborhood;
import com.blacksmith.nikiti.service.NeighborhoodService;

import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.*;
import org.primefaces.PrimeFaces;
import com.blacksmith.nikiti.model.City;      

@Named
@ViewScoped
public class NeighborhoodListMB extends CrudMB<Neighborhood> implements Serializable {

    @Inject
    NeighborhoodService neighborhoodService;

    @Inject
    public void initService() {
        setCrudService(neighborhoodService);
    }

    public void delete() {
        int deletedEntities = 0;
        for (Neighborhood selected : selectionList) {
        	deletedEntities++;
        	neighborhoodService.remove(selected);
        }
        selectionList.clear();
        addDetailMessage(deletedEntities + " neighborhood(s) deleted successfully!");
        clear();
    }

    /**
     * Used in datatable footer to display current search criteria
     */
    public String getSearchCriteria() {
        StringBuilder sb = new StringBuilder(21);
        Neighborhood neighborhoodFilter = filter.getEntity();
 
        Long id = null;
        if (filter.hasParam("id")) {
            id = filter.getLongParam("id");
        } else if (has(neighborhoodFilter.getId())) {
            id = neighborhoodFilter.getId();
        }
        if (has(id)) {
  
	        sb.append("<b>id</b>: ").append(id).append(", ");
        }
 
        String name = null;
        if (filter.hasParam("name")) {
            name = (String)filter.getParam("name");
        } else if (has(neighborhoodFilter.getName())) {
            name = neighborhoodFilter.getName();
        }
        if (has(name)) {
  
	        sb.append("<b>name</b>: ").append(name).append(", ");
        }
 
        String description = null;
        if (filter.hasParam("description")) {
            description = (String)filter.getParam("description");
        } else if (has(neighborhoodFilter.getDescription())) {
            description = neighborhoodFilter.getDescription();
        }
        if (has(description)) {
  
	        sb.append("<b>description</b>: ").append(description).append(", ");
        }
 
        City city = null;
        if (filter.hasParam("city")) {
            city = (City)filter.getParam("city");
        } else if (has(neighborhoodFilter.getCity())) {
            city = neighborhoodFilter.getCity();
        }
        if (has(city)) {
            sb.append("<b>city</b>: ").append(city.getName()).append(", ");
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

    public List<City> completeCity(String query) {
        return neighborhoodService.getCitysByName(query);
    }
}