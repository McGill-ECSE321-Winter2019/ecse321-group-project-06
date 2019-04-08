package ca.mcgill.ecse321.cooperator.repository;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.cooperator.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	/**
	 * find an student by name
	 * 
	 * @param name
	 * @return
	 */
	Student findByName(String name);
	
	/**
	 * find an student by id
	 * 
	 * @param id
	 * @return
	 */
	Student findById(int id);
	
	/**
	 * delete all students
	 */
	void deleteAll();
} 