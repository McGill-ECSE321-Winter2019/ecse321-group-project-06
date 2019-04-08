package ca.mcgill.ecse321.cooperator.repository;

 import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.Event;

 public interface EventRepository extends CrudRepository<Event, Integer>{
	 /**
	  * find Event by start date
	  * 
	  * @param startDate
	  * @return Event
	  */
	 Event findByStartDate(Date startDate);
	 
	 /**
	  * get an event by end date
	  * @param endDate
	  * @return Event
	  */
	 Event findByEndDate(Date endDate);
	 
	 /**
	  * get an event by the location
	  * 
	  * @param location
	  * @return Event
	  */
	 Event findByLocation(String location);
	 
	 /**
	  * get an event by id
	  * @param id
	  * @return
	  */
	 Event findById(int id);
	 
	 /**
	  * delete an event by id
	  * @param id
	  */
	 void deleteById(int id);
 }