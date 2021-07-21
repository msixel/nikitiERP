package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.github.adminfaces.persistence.util.Messages;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import com.blacksmith.nikiti.model.Country;
import com.blacksmith.nikiti.service.CountryService;

import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.*;
import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class CountryListMB extends CrudMB<Country> implements Serializable {

    @Inject
    CountryService countryService;

    @Inject
    public void initService() {
        setCrudService(countryService);
    }

    public void delete() {
        int deletedEntities = 0;
        for (Country selected : selectionList) {
        	deletedEntities++;
        	countryService.remove(selected);
        }
        selectionList.clear();
        addDetailMessage(deletedEntities + " country(s) deleted successfully!");
        clear();
    }

    /**
     * Used in datatable footer to display current search criteria
     */
    public String getSearchCriteria() {
        StringBuilder sb = new StringBuilder(21);
        Country countryFilter = filter.getEntity();
 
        Long id = null;
        if (filter.hasParam("id")) {
            id = filter.getLongParam("id");
        } else if (has(countryFilter.getId())) {
            id = countryFilter.getId();
        }
        if (has(id)) {
  
	        sb.append("<b>id</b>: ").append(id).append(", ");
        }
 
        String code = null;
        if (filter.hasParam("code")) {
            code = (String)filter.getParam("code");
        } else if (has(countryFilter.getCode())) {
            code = countryFilter.getCode();
        }
        if (has(code)) {
  
	        sb.append("<b>code</b>: ").append(code).append(", ");
        }
 
        String name = null;
        if (filter.hasParam("name")) {
            name = (String)filter.getParam("name");
        } else if (has(countryFilter.getName())) {
            name = countryFilter.getName();
        }
        if (has(name)) {
  
	        sb.append("<b>name</b>: ").append(name).append(", ");
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

}