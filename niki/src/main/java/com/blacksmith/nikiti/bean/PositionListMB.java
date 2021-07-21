package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.github.adminfaces.persistence.util.Messages;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import com.blacksmith.nikiti.model.Position;
import com.blacksmith.nikiti.service.PositionService;

import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.util.*;
import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class PositionListMB extends CrudMB<Position> implements Serializable {

    @Inject
    PositionService positionService;

    @Inject
    public void initService() {
        setCrudService(positionService);
    }

    public void delete() {
        int deletedEntities = 0;
        for (Position selected : selectionList) {
        	deletedEntities++;
        	positionService.remove(selected);
        }
        selectionList.clear();
        addDetailMessage(deletedEntities + " position(s) deleted successfully!");
        clear();
    }

    /**
     * Used in datatable footer to display current search criteria
     */
    public String getSearchCriteria() {
        StringBuilder sb = new StringBuilder(21);
        Position positionFilter = filter.getEntity();
 
        Long id = null;
        if (filter.hasParam("id")) {
            id = filter.getLongParam("id");
        } else if (has(positionFilter.getId())) {
            id = positionFilter.getId();
        }
        if (has(id)) {
  
	        sb.append("<b>id</b>: ").append(id).append(", ");
        }
 
        String name = null;
        if (filter.hasParam("name")) {
            name = (String)filter.getParam("name");
        } else if (has(positionFilter.getName())) {
            name = positionFilter.getName();
        }
        if (has(name)) {
  
	        sb.append("<b>name</b>: ").append(name).append(", ");
        }
 
        String description = null;
        if (filter.hasParam("description")) {
            description = (String)filter.getParam("description");
        } else if (has(positionFilter.getDescription())) {
            description = positionFilter.getDescription();
        }
        if (has(description)) {
  
	        sb.append("<b>description</b>: ").append(description).append(", ");
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