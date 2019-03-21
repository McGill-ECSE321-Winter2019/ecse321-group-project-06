package ca.mcgill.ecse321.cooperator.repository;

 import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.Event;

 public interface EventRepository extends CrudRepository<Event, Integer>{
	 Event findByStartDate(Date startDate);
	 Event findByEndDate(Date endDate);
	 Event findByLocation(String location);
	 Event findById(int id);
	 void deleteById(int id);
	 //void delete(Event event);
 }