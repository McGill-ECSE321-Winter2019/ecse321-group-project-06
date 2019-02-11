package ca.mcgill.ecse321.cooperator.repository;

 import org.springframework.data.repository.CrudRepository;

 import ca.mcgill.ecse321.cooperator.entity.Event;

 public interface EventRepository extends CrudRepository<Event, Integer>{

 }