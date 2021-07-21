/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.blacksmith.nikiti.model.Neighborhood;
import com.blacksmith.nikiti.service.NeighborhoodService;
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
import com.blacksmith.nikiti.model.City;      


@Named
@ViewScoped
public class NeighborhoodFormMB extends CrudMB<Neighborhood> implements Serializable {

    @Inject
    NeighborhoodService neighborhoodService;

    @Inject
    public void initService() {
        setCrudService(neighborhoodService);
    }

    @Override
    public void afterRemove() {
        try {
            super.afterRemove();//adds remove message
            Faces.redirect("neighborhood/neighborhood-list.xhtml");
            clear(); 
            sessionFilter.clear(NeighborhoodFormMB.class.getName());//removes filter saved in session for this bean.
        } catch (Exception e) {
            log.log(Level.WARNING, "",e);
        }
    }

    public List<City> completeCity(String query) {
        return neighborhoodService.getCitysByName(query);
    }
 

}
