package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.github.adminfaces.persistence.util.Messages;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import com.blacksmith.nikiti.model.City;
import com.blacksmith.nikiti.service.CityService;

import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.*;
import org.primefaces.PrimeFaces;
import com.blacksmith.nikiti.model.Province;      

@Named
@ViewScoped
public class CityListMB extends CrudMB<City> implements Serializable {

    @Inject
    CityService cityService;

    @Inject
    public void initService() {
        setCrudService(cityService);
    }

    public void delete() {
        int deletedEntities = 0;
        for (City selected : selectionList) {
        	deletedEntities++;
        	cityService.remove(selected);
        }
        selectionList.clear();
        addDetailMessage(deletedEntities + " city(s) deleted successfully!");
        clear();
    }

    /**
     * Used in datatable footer to display current search criteria
     */
    public String getSearchCriteria() {
        StringBuilder sb = new StringBuilder(21);
        City cityFilter = filter.getEntity();
 
        Long id = null;
        if (filter.hasParam("id")) {
            id = filter.getLongParam("id");
        } else if (has(cityFilter.getId())) {
            id = cityFilter.getId();
        }
        if (has(id)) {
  
	        sb.append("<b>id</b>: ").append(id).append(", ");
        }
 
        String name = null;
        if (filter.hasParam("name")) {
            name = (String)filter.getParam("name");
        } else if (has(cityFilter.getName())) {
            name = cityFilter.getName();
        }
        if (has(name)) {
  
	        sb.append("<b>name</b>: ").append(name).append(", ");
        }
 
        String description = null;
        if (filter.hasParam("description")) {
            description = (String)filter.getParam("description");
        } else if (has(cityFilter.getDescription())) {
            description = cityFilter.getDescription();
        }
        if (has(description)) {
  
	        sb.append("<b>description</b>: ").append(description).append(", ");
        }
 
        Province province = null;
        if (filter.hasParam("province")) {
            province = (Province)filter.getParam("province");
        } else if (has(cityFilter.getProvince())) {
            province = cityFilter.getProvince();
        }
        if (has(province)) {
            sb.append("<b>province</b>: ").append(province.getCode()).append(", ");
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

    public List<Province> completeProvince(String query) {
        return cityService.getProvincesByCode(query);
    }
}