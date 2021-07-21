package com.blacksmith.nikiti.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import com.blacksmith.nikiti.model.Facility;

@Repository
public interface FacilityRepository extends EntityRepository<Facility,Long> {

}