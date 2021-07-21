/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.blacksmith.nikiti.model.City;
import com.blacksmith.nikiti.service.CityService;
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
import com.blacksmith.nikiti.model.Province;      


@Named
@ViewScoped
public class CityFormMB extends CrudMB<City> implements Serializable {

    @Inject
    CityService cityService;

    @Inject
    public void initService() {
        setCrudService(cityService);
    }

    @Override
    public void afterRemove() {
        try {
            super.afterRemove();//adds remove message
            Faces.redirect("city/city-list.xhtml");
            clear(); 
            sessionFilter.clear(CityFormMB.class.getName());//removes filter saved in session for this bean.
        } catch (Exception e) {
            log.log(Level.WARNING, "",e);
        }
    }

    public List<Province> completeProvince(String query) {
        return cityService.getProvincesByCode(query);
    }
 

}
