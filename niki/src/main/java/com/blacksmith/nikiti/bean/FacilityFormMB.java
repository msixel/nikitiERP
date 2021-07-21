/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.blacksmith.nikiti.model.Facility;
import com.blacksmith.nikiti.service.FacilityService;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import javax.inject.Named;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import static com.github.adminfaces.persistence.util.Messages.addDetailMessage;
import static com.github.adminfaces.persistence.util.Messages.getMessage;

import java.util.*;
import com.blacksmith.nikiti.model.Country;      
import com.blacksmith.nikiti.model.Province;      
import com.blacksmith.nikiti.model.City;      
import com.blacksmith.nikiti.model.Neighborhood;      
import com.blacksmith.nikiti.model.Company;   
import com.blacksmith.nikiti.model.Employee;   


@Named
@ViewScoped
public class FacilityFormMB extends CrudMB<Facility> implements Serializable {

    @Inject
    FacilityService facilityService;

    @Inject
    public void initService() {
        setCrudService(facilityService);
    }

    @Override
    public void afterRemove() {
        try {
            super.afterRemove();//adds remove message
            Faces.redirect("facility/facility-list.xhtml");
            clear(); 
            sessionFilter.clear(FacilityFormMB.class.getName());//removes filter saved in session for this bean.
        } catch (Exception e) {
            log.log(Level.WARNING, "",e);
        }
    }

    public List<Country> completeCountry(String query) {
        return facilityService.getCountrysByCode(query);
    }
    public List<Province> completeProvince(String query) {
        return facilityService.getProvincesByCode(query);
    }
    public List<City> completeCity(String query) {
        return facilityService.getCitysByName(query);
    }
    public List<Neighborhood> completeNeighborhood(String query) {
        return facilityService.getNeighborhoodsByName(query);
    }
 

}
