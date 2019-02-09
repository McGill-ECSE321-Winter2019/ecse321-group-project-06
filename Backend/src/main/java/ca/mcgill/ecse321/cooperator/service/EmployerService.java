package ca.mcgill.ecse321.cooperator.service;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import org.springframework.data.repository.CrudRepository;



@Service
public class EmployerService {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	EmployerRepository employerRepository;

	@Transactional
	public Employer createEmployer(String userEmail, String userPassword, String companyName, int employerId) {
		Employer e = new Employer(userEmail, userPassword, companyName, employerId);
		entityManager.persist(e);
		return e;
	}
	
	@Transactional
	public Employer getEmployer(int employerId) {
		Employer e = entityManager.find(Employer.class, employerId);
		return e;
	}
	
	@Transactional
	public List<Employer> getAllEmployers() {
		return (List<Employer>) employerRepository.findAll();
	}

	
}

