package com.blacksmith.nikiti.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import com.blacksmith.nikiti.model.Schedule;

@Repository
public interface ScheduleRepository extends EntityRepository<Schedule,Long> {

}