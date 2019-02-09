package ca.mcgill.ecse321.cooperator.repository;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.Employer;


public interface EmployerRepository extends CrudRepository<Employer, Integer> {
	
	public Employer createEmployer(String userEmail, String userPassword, String companyName, int employerId);
	
	public Employer getEmployer(int employerId);


}
