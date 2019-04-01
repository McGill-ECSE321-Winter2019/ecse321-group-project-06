package ca.mcgill.ecse321.cooperator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.EmployerDto;
import ca.mcgill.ecse321.cooperator.dto.EventDto;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.service.EmployerService;


@CrossOrigin(origins = "*")
@RestController
public class EmployerController {
	@Autowired
	private EmployerService service;

	/**
	 * employer account sign up 
	 * @param  @RequestBody
	 * @return employerDto
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/employers", "/employers/" })
	@ResponseBody
	public EmployerDto signUp(@RequestBody EmployerDto e ) throws IllegalArgumentException {

		Employer employer = service.createEmployer(e.getEmail(), e.getPassword(), e.getName());
		return convertToDto(employer);
	}


	/**
	 * get an employer by employerId
	 * @param employerId
	 * @return an Employer Dto 
	 */
	@GetMapping(value = {"/employer/{employerId}", "/employer/{employerId}"})
	@ResponseBody
	public EmployerDto getEmployer(@PathVariable("employerId") int employerId){

		EmployerDto returnEmployer = null;
		for(Employer employer: service.getAllEmployers()) {
			if (employer.getCoopUserId()== employerId) {
				returnEmployer = convertToDto(employer);
			}
		}
		return returnEmployer;
	}


	/**
	 * employer account login 
	 * @param email
	 * @param password
	 * @return
	 */
	@GetMapping(value = { "/login", "/login/" })
	@ResponseBody
	public EmployerDto login(@RequestParam("Email") String email, @RequestParam("Password") String password) {
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


	/**
	 * Get all employers 
	 * @return employerdtos
	 */
	@GetMapping(value = {"/employers","/employers/"})
	@ResponseBody
	public List<EmployerDto> getAllEmployers() {
		List<EmployerDto> employers = new ArrayList<>();
		for (Employer employer : service.getAllEmployers()) {
			employers.add(convertToDto(employer));
		}
		return employers;
	}

	
	/**
	 * delete employer by Id 
	 * @param id
	 */
	@DeleteMapping(value = {"/employes/{id}"})
	@ResponseBody
	public void delete(@PathVariable int id){
		service.deleteEmployer(id);
	}

	private EmployerDto convertToDto(Employer employer) {
		if (employer == null) {
			throw new IllegalArgumentException("There is no such employer!");
		}
		EmployerDto employerDto  = new EmployerDto(employer.getEmail(), employer.getPassword(), employer.getName(), employer.getCoopUserId());
		return employerDto;
	}
}
