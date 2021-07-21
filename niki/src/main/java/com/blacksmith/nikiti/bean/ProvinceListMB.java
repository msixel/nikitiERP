package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.github.adminfaces.persistence.util.Messages;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import com.blacksmith.nikiti.model.Province;
import com.blacksmith.nikiti.service.ProvinceService;

import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.*;
import org.primefaces.PrimeFaces;
import com.blacksmith.nikiti.model.Country;      

@Named
@ViewScoped
public class ProvinceListMB extends CrudMB<Province> implements Serializable {

    @Inject
    ProvinceService provinceService;

    @Inject
    public void initService() {
        setCrudService(provinceService);
    }

    public void delete() {
        int deletedEntities = 0;
        for (Province selected : selectionList) {
        	deletedEntities++;
        	provinceService.remove(selected);
        }
        selectionList.clear();
        addDetailMessage(deletedEntities + " province(s) deleted successfully!");
        clear();
    }

    /**
     * Used in datatable footer to display current search criteria
     */
    public String getSearchCriteria() {
        StringBuilder sb = new StringBuilder(21);
        Province provinceFilter = filter.getEntity();
 
        Long id = null;
        if (filter.hasParam("id")) {
            id = filter.getLongParam("id");
        } else if (has(provinceFilter.getId())) {
            id = provinceFilter.getId();
        }
        if (has(id)) {
  
	        sb.append("<b>id</b>: ").append(id).append(", ");
        }
 
        String code = null;
        if (filter.hasParam("code")) {
            code = (String)filter.getParam("code");
        } else if (has(provinceFilter.getCode())) {
            code = provinceFilter.getCode();
        }
        if (has(code)) {
  
	        sb.append("<b>code</b>: ").append(code).append(", ");
        }
 
        String name = null;
        if (filter.hasParam("name")) {
            name = (String)filter.getParam("name");
        } else if (has(provinceFilter.getName())) {
            name = provinceFilter.getName();
        }
        if (has(name)) {
  
	        sb.append("<b>name</b>: ").append(name).append(", ");
        }
 
        Country country = null;
        if (filter.hasParam("country")) {
            country = (Country)filter.getParam("country");
        } else if (has(provinceFilter.getCountry())) {
            country = provinceFilter.getCountry();
        }
        if (has(country)) {
            sb.append("<b>country</b>: ").append(country.getCode()).append(", ");
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

    public List<Country> completeCountry(String query) {
        return provinceService.getCountrysByCode(query);
    }
}