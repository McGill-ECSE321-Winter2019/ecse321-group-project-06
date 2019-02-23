package ca.mcgill.ecse321.cooperator.repository;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.cooperator.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	Student findByName(String name);
} 