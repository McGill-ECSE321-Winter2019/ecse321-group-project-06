package ca.mcgill.ecse321.cooperator.repository;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Integer> {
	/**
	 * get employer by name
	 * 
	 * @param name
	 * @return Employer
	 */
	Employer findByName(String name);
	
	/**
	 * get employer by email
	 * 
	 * @param email
	 * @return Employer
	 */
	Employer findByEmail(String email);
	
	/**
	 * get employer by id
	 * 
	 * @param id
	 * @return Employer
	 */
	Employer findById(int id);
	
	/**
	 * delete an employer
	 * @param id
	 */
	void deleteById(int id);
}
