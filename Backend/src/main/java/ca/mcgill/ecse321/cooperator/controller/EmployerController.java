package ca.mcgill.ecse321.cooperator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.EmployerDto;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.service.EmployerService;

@CrossOrigin(origins = "*")
@RestController
public class EmployerController {
	@Autowired
	private EmployerService service;
	
	/**
	 * 
	 * @param  @RequestBody
	 * @return employerDto
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/employers", "/employers/" })
	public EmployerDto signup(@RequestBody EmployerDto e ) throws IllegalArgumentException {
		Employer employer = service.createEmployer(e.getEmail(), e.getPassword(), e.getName());
		return convertToDto(employer);
	}

	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@GetMapping(value = { "/login", "/login/" })
	public EmployerDto login(@RequestParam String email, @RequestParam String password) {
		List<EmployerDto> employers = new ArrayList<>();
		for (Employer employer : service.getAllEmployers()) {
			
			if(employer.getEmail() == email) {
				if(employer.getPassword() == password) {
					// valid password , add to list 
					employers.add(convertToDto(employer));
				}else {
					// throw exception
					 throw new IllegalArgumentException("Password is not correct! Try again.");
				}
			}
		}
		
		// if the list is empty, then no such email in database
		if (employers.isEmpty()) {
			throw new IllegalArgumentException("This email is not registered, please register first!");
		}
		// return the first element in the list
		return employers.get(0);
	}

	
	private EmployerDto convertToDto(Employer employer) {
		if (employer == null) {
			throw new IllegalArgumentException("There is no such employer!");
		}
		EmployerDto employerDto  = new EmployerDto(employer.getEmail(), employer.getPassword(), employer.getName(), employer.getCoopUserId());
		return employerDto;
	}
}
