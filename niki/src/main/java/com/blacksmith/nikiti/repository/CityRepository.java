package com.blacksmith.nikiti.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import com.blacksmith.nikiti.model.City;

@Repository
public interface CityRepository extends EntityRepository<City,Long> {

}