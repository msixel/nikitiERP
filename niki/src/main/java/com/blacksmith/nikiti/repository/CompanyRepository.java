package com.blacksmith.nikiti.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import com.blacksmith.nikiti.model.Company;

@Repository
public interface CompanyRepository extends EntityRepository<Company,Long> {

}