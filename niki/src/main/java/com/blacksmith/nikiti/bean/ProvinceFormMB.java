/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.blacksmith.nikiti.model.Province;
import com.blacksmith.nikiti.service.ProvinceService;
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


@Named
@ViewScoped
public class ProvinceFormMB extends CrudMB<Province> implements Serializable {

    @Inject
    ProvinceService provinceService;

    @Inject
    public void initService() {
        setCrudService(provinceService);
    }

    @Override
    public void afterRemove() {
        try {
            super.afterRemove();//adds remove message
            Faces.redirect("province/province-list.xhtml");
            clear(); 
            sessionFilter.clear(ProvinceFormMB.class.getName());//removes filter saved in session for this bean.
        } catch (Exception e) {
            log.log(Level.WARNING, "",e);
        }
    }

    public List<Country> completeCountry(String query) {
        return provinceService.getCountrysByCode(query);
    }
 

}
