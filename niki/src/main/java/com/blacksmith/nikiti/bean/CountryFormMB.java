/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.blacksmith.nikiti.model.Country;
import com.blacksmith.nikiti.service.CountryService;
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


@Named
@ViewScoped
public class CountryFormMB extends CrudMB<Country> implements Serializable {

    @Inject
    CountryService countryService;

    @Inject
    public void initService() {
        setCrudService(countryService);
    }

    @Override
    public void afterRemove() {
        try {
            super.afterRemove();//adds remove message
            Faces.redirect("country/country-list.xhtml");
            clear(); 
            sessionFilter.clear(CountryFormMB.class.getName());//removes filter saved in session for this bean.
        } catch (Exception e) {
            log.log(Level.WARNING, "",e);
        }
    }

 

}
