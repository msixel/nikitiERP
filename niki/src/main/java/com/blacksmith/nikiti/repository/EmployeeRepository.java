package com.blacksmith.nikiti.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import com.blacksmith.nikiti.model.Employee;

@Repository
public interface EmployeeRepository extends EntityRepository<Employee,Long> {

}