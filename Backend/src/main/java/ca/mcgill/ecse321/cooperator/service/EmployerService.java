package ca.mcgill.ecse321.cooperator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;

@Service
public class EmployerService {
	
	@Autowired
	EmployerRepository employerRepository;

	/* exceptions */
	@Transactional
	public Employer createEmployer(String userEmail, String userPassword, String companyName) {
		Employer e = new Employer();
		
		if (userEmail == null || userEmail.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			throw new IllegalArgumentException("password cannot be empty!");
		}
	    if (companyName == null || companyName.trim().length() == 0) {
			throw new IllegalArgumentException("company name cannot be empty!");
		}
	    
	    e.setEmail(userEmail);
		e.setPassword(userPassword);
		e.setName(companyName);
		Employer eReturn = employerRepository.save(e);
		
		return eReturn;
	}
	
	/* id getter */
	@Transactional
	public Employer getEmployer(int id) {
		
		if (String.valueOf(id).length() < 1) {
	        throw new IllegalArgumentException("company name cannot be empty!");
	    }
	    
		Employer e = employerRepository.findById(id).get();
		return e;
	}
	
	/* get all employers in the list */
	@Transactional
	public List<Employer> getAllEmployers() {
		return toList(employerRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

}
