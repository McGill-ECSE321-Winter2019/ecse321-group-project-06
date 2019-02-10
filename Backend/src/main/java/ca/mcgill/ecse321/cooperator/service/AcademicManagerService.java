package ca.mcgill.ecse321.cooperator.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.ecse321.cooperator.entity.AcademicManager;
import ca.mcgill.ecse321.cooperator.repository.AcademicManagerRepository;


@Service
public class AcademicManagerService {
	
	@Autowired
	AcademicManagerRepository academicManagerRepository;
	
	//@Autowired
	//EntityManager entityManager;

	
	@Transactional
	public AcademicManager createAcademicManager(String email, String password, String name) {
	
		// throw exceptions
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("name cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("email cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("password cannot be empty!");
		}
		
		// set attributes
		AcademicManager academicManager = new AcademicManager();
		academicManager.setEmail(email);
		academicManager.setName(name);
		academicManager.setPassword(password);
		
		// return created object
		AcademicManager academicManagerReturn = academicManagerRepository.save(academicManager);
		return academicManagerReturn;
		
	}

	
	@Transactional
	public AcademicManager getAcademicManager(int id) {
		AcademicManager academicManager = academicManagerRepository.findById(id).get();
		return academicManager;
	}
	
	
	@Transactional
	public List<AcademicManager> getAllAcademicManager() {
		return toList(academicManagerRepository.findAll());
	}


	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
	
	

}
