/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blacksmith.nikiti.bean;

import com.github.adminfaces.persistence.bean.CrudMB;
import com.blacksmith.nikiti.model.Employee;
import com.blacksmith.nikiti.service.EmployeeService;
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
import com.blacksmith.nikiti.model.Position;      
import com.blacksmith.nikiti.model.Schedule;      
import com.blacksmith.nikiti.model.Company;      


@Named
@ViewScoped
public class EmployeeFormMB extends CrudMB<Employee> implements Serializable {

    @Inject
    EmployeeService employeeService;

    @Inject
    public void initService() {
        setCrudService(employeeService);
    }

    @Override
    public void afterRemove() {
        try {
            super.afterRemove();//adds remove message
            Faces.redirect("employee/employee-list.xhtml");
            clear(); 
            sessionFilter.clear(EmployeeFormMB.class.getName());//removes filter saved in session for this bean.
        } catch (Exception e) {
            log.log(Level.WARNING, "",e);
        }
    }

    public List<Country> completeCountry(String query) {
        return employeeService.getCountrysByCode(query);
    }
    public List<Province> completeProvince(String query) {
        return employeeService.getProvincesByCode(query);
    }
    public List<City> completeCity(String query) {
        return employeeService.getCitysByName(query);
    }
    public List<Neighborhood> completeNeighborhood(String query) {
        return employeeService.getNeighborhoodsByName(query);
    }
    public List<Position> completePosition(String query) {
        return employeeService.getPositionsByName(query);
    }
    public List<Schedule> completeSchedule(String query) {
        return employeeService.getSchedulesByName(query);
    }
    public List<Company> completeCompany(String query) {
        return employeeService.getCompanysByName(query);
    }
 

}
