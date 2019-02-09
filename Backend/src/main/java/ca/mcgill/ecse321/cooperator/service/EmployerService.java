package ca.mcgill.ecse321.cooperator.service;


import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;



@Service
public class EmployerService {
	
	//@Autowired
	//EntityManager entityManager;
	
	@Autowired
	EmployerRepository employerRepository;

	@Transactional
	public Employer createEmployer(String userEmail, String userPassword, String companyName) {
		Employer e = new Employer(userEmail, userPassword, companyName);
	//	entityManager.persist(e);
		
		if (userEmail == null || userEmail.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			throw new IllegalArgumentException("password cannot be empty!");
		}
	    if (companyName == null || companyName.trim().length() ==0) {
			throw new IllegalArgumentException("company name cannot be empty!");
		}
	    
	    e.setEmail(userEmail);
		e.setPassword(userPassword);
		e.setName(companyName);
		Employer eReturn = employerRepository.save(e);
		
		return eReturn;
	}
	
	@Transactional
	public Employer getEmployer(String userEmail) {
		if (userEmail == null || userEmail.trim().length() == 0) {
	        throw new IllegalArgumentException("company name cannot be empty!");
	    }
		Employer e = employerRepository.findByEmailAddress(userEmail);
		return e;
	}
	
	@Transactional
	public List<Employer> getAllEmployers() {
		return (List<Employer>) employerRepository.findAll();
	}
}

